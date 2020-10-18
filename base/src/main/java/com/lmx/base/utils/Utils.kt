package com.lmx.base.utils

import android.content.Context

/**
 * @Desc: Utils初始化相关
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
class Utils private constructor() {
    companion object {
        private var context: Context? = null
        /**
         * 初始化工具类
         *
         * @param context 上下文
         */
        fun init(context: Context) {
            Companion.context = context.applicationContext
        }

        /**
         * 获取ApplicationContext
         *
         * @return ApplicationContext
         */
        fun getContext(): Context? {
            if (context != null) return context
            throw NullPointerException("u should init first")
        }
    }

    init {
        throw UnsupportedOperationException("u can't instantiate me...")
    }
}