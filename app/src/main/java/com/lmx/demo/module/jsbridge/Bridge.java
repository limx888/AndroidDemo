package com.lmx.demo.module.jsbridge;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc: bridge manager
 * @Author: limingxia
 * @Date: Created on 2020/2/25 9:19 AM
 * @Modified By:
 */
public enum Bridge {

    INSTANCE;

    private String TAG = "Bridge";
    private Boolean DEBUG = false;
    private Map<String, BridgeHandler> mMessageHandlers = new HashMap<>();

    public Boolean getDEBUG() {
        return DEBUG;
    }

    public void openLog() {
        this.DEBUG = true;
    }

    /**
     * global all handlers
     *
     * @return
     */
    public Map<String, BridgeHandler> getMessageHandlers() {
        return mMessageHandlers;
    }

    /**
     * register handler,so that javascript can call it
     * 注册处理程序,以便javascript调用它
     *
     * @param handlerName handlerName
     * @param handler     BridgeHandler
     */
    public void registerHandler(String handlerName, BridgeHandler handler) {
        if (handler != null) {
            // 添加至 Map<String, BridgeHandler>
            mMessageHandlers.put(handlerName, handler);
        }
    }


    /**
     * register handler,so that javascript can call it
     * 注册处理程序,以便javascript调用它
     *
     * @param handlers handlerName
     */
    public void registerHandler(Map<String, BridgeHandler> handlers) {
        if (handlers != null) {
            mMessageHandlers.putAll(handlers);
        }
    }


    /**
     * unregister handler
     *
     * @param handlerName
     */
    public void unregisterHandler(String handlerName) {
        if (handlerName != null) {
            mMessageHandlers.remove(handlerName);
        }
    }

}
