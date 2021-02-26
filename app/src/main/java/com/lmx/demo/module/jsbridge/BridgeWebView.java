package com.lmx.demo.module.jsbridge;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc: BridgeWebView
 * @Author: limingxia
 * @Date: Created on 2020/2/25 9:19 AM
 * @Modified By:
 */
@SuppressLint("SetJavaScriptEnabled")
public class BridgeWebView extends WebView implements IWebView {
    private String TAG = "BridgeWebView";
    private BridgeTiny bridgeTiny;
    private BridgeWebViewClient mClient;
    private BridgeWebviewChromeClient mChromeClient;
    private Map<String, BridgeHandler> mLocalMessageHandlers = new HashMap<>();

    public BridgeWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BridgeWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public BridgeWebView(Context context) {
        super(context);
        init();
    }

    private void init() {
        clearCache(true);
        getSettings().setUseWideViewPort(true);
//		webView.getSettings().setLoadWithOverviewMode(true);
        getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        getSettings().setJavaScriptEnabled(true);
//        mContent.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Bridge.INSTANCE.getDEBUG()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        bridgeTiny = new BridgeTiny(this);
        mClient = new BridgeWebViewClient(this, bridgeTiny);
        mChromeClient = new BridgeWebviewChromeClient(this, bridgeTiny);
        super.setWebViewClient(mClient);
        super.setWebChromeClient(mChromeClient);
    }

    @Override
    public void setWebViewClient(WebViewClient client) {
        mClient.setWebViewClient(client);
    }

    @Override
    public void destroy() {
        super.destroy();
        bridgeTiny.freeMemory();
    }

    @Override
    public void addHandlerLocal(String handlerName, BridgeHandler bridgeHandler) {

        mLocalMessageHandlers.put(handlerName, bridgeHandler);
    }

    @Override
    public Map<String, BridgeHandler> getLocalMessageHandlers() {
        return mLocalMessageHandlers;
    }

    @Override
    public void evaluateJavascript(String var1, Object object) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            super.evaluateJavascript(var1, (ValueCallback<String>) object);
        }
    }

    @Override
    public void callHandler(String handlerName, Object data, OnBridgeCallback responseCallback) {
        bridgeTiny.callHandler(handlerName, data, responseCallback);
    }

}
