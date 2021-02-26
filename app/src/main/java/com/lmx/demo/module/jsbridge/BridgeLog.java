package com.lmx.demo.module.jsbridge;

import android.util.Log;

/**
 * @Desc: BridgeLog
 * @Author: limingxia
 * @Date: Created on 2020/2/25 9:19 AM
 * @Modified By:
 */
public class BridgeLog {
    public static void d(String tag, String message) {
        if (Bridge.INSTANCE.getDEBUG()) {
            Log.d(tag, message);
        }
    }

    public static void i(String tag, String message) {
        if (Bridge.INSTANCE.getDEBUG()) {
            Log.i(tag, message);
        }
    }

    public static void w(String tag, String message) {
        if (Bridge.INSTANCE.getDEBUG()) {
            Log.w(tag, message);
        }
    }

    public static void e(String tag, String message) {
        if (Bridge.INSTANCE.getDEBUG()) {
            Log.e(tag, message);
        }
    }
}
