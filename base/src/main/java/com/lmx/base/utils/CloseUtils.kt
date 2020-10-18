package com.lmx.base.utils

import java.io.Closeable
import java.io.IOException

/**
 * @Desc: 关闭相关工具类
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
class CloseUtils private constructor() {
    companion object {
        /**
         * 关闭IO
         *
         * @param closeables closeable
         */
        fun closeIO(vararg closeables: Closeable?) {
            if (closeables == null) return
            for (closeable in closeables) {
                if (closeable != null) {
                    try {
                        closeable.close()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }
        }

        /**
         * 安静关闭IO
         *
         * @param closeables closeable
         */
        fun closeIOQuietly(vararg closeables: Closeable?) {
            if (closeables == null) return
            for (closeable in closeables) {
                if (closeable != null) {
                    try {
                        closeable.close()
                    } catch (ignored: IOException) {
                    }
                }
            }
        }
    }

    init {
        throw UnsupportedOperationException("u can't instantiate me...")
    }
}