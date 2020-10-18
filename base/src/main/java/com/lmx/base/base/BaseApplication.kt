package com.lmx.base.base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
abstract class BaseApplication : Application() {
    abstract fun initBaseConfig() //初始化配置参数
    override fun onCreate() {
        super.onCreate()
        initBaseConfig()
        //ARouter的初始化
        ARouter.init(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        ARouter.getInstance().destroy()
    }

}