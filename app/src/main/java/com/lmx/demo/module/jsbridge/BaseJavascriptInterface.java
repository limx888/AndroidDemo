package com.lmx.demo.module.jsbridge;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;

import java.util.Map;

/**
 * @Desc: BaseJavascriptInterface
 * @Author: limingxia
 * @Date: Created on 2020/2/25 9:19 AM
 * @Modified By:
 */
public abstract class BaseJavascriptInterface {

    private String TAG = "BaseJavascriptInterface";
    Handler mMainHandler = new Handler(Looper.getMainLooper());
    private Map<String, OnBridgeCallback> mCallbacks;

    public BaseJavascriptInterface(Map<String, OnBridgeCallback> callbacks) {
        mCallbacks = callbacks;
    }

    @JavascriptInterface
    public String send(String data, String callbackId) {
        return send(data);
    }

    @JavascriptInterface
    public void response(final String data, final String responseId) {
        BridgeLog.d(TAG, "response->" + data + ", responseId: " + responseId + " " + Thread.currentThread().getName());

        if (!TextUtils.isEmpty(responseId)) {
            mMainHandler.post(new Runnable() {
                @Override
                public void run() {
                    OnBridgeCallback function = mCallbacks.remove(responseId);
                    if (function != null) {
                        function.onCallBack(data);
                    }
                }
            });
        }
    }

    public abstract String send(String data);
}
