package com.lmx.demo.module.jsbridge;

import android.content.Context;

/**
 * @Desc: BridgeHandler
 * @Author: limingxia
 * @Date: Created on 2020/2/25 9:19 AM
 * @Modified By:
 */
public abstract class BridgeHandler {

    public abstract void handler(Context context, String data, CallBackFunction function);

}