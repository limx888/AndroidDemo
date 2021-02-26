package com.lmx.demo.module.jsbridge;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;

import java.util.Map;

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/2/25 9:19 AM
 * @Modified By:
 */
public class BridgeJavascritInterface extends BaseJavascriptInterface {

    private IWebView mWebView;
    private BridgeTiny mBridge;

    public BridgeJavascritInterface(Map<String, OnBridgeCallback> callbacks, BridgeTiny bridge, IWebView webView) {
        super(callbacks);
        this.mWebView = webView;
        this.mBridge = bridge;
    }

    @Override
    public String send(String data) {
        return "it is default response";
    }

    @JavascriptInterface
    public void handler(final String handlerName, final String data, final String callbackId) {
        if (TextUtils.isEmpty(handlerName)) {
            return;
        }
        //change to main thread
        mMainHandler.post(new Runnable() {
            @Override
            public void run() {
                //higher priority LocalMessageHandlers
                if (mWebView.getLocalMessageHandlers().containsKey(handlerName)) {
                    BridgeHandler bridgeHandler = mWebView.getLocalMessageHandlers().get(handlerName);
                    bridgeHandler.handler(mWebView.getContext(), data, new CallBack(callbackId));
                    return;
                }

                if (mBridge.getMessageHandlers().containsKey(handlerName)) {
                    BridgeHandler bridgeHandler = mBridge.getMessageHandlers().get(handlerName);
                    bridgeHandler.handler(mWebView.getContext(), data, new CallBack(callbackId));
                }
            }
        });

    }

    public class CallBack implements CallBackFunction {
        private String callbackId;

        public CallBack(String callbackId) {
            this.callbackId = callbackId;
        }

        @Override
        public void onCallBack(String data) {
            mBridge.sendResponse(data, callbackId);
        }
    }
}
