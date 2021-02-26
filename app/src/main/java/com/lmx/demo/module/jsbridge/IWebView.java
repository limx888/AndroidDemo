package com.lmx.demo.module.jsbridge;

import android.content.Context;

import java.util.Map;

/**
 * @Desc: abstract WebView common interface
 * @Author: limingxia
 * @Date: Created on 2020/2/25 9:19 AM
 * @Modified By:
 */
public interface IWebView {
    void loadUrl(String url);

    void addHandlerLocal(String handlerName, BridgeHandler bridgeHandler);

    Map<String, BridgeHandler> getLocalMessageHandlers();

    void addJavascriptInterface(Object obj, String interfaceName);

    void evaluateJavascript(String var1, Object object);

    void callHandler(String handlerName, Object data, OnBridgeCallback responseCallback);

    void removeJavascriptInterface(String cmd);

    Context getContext();
}
