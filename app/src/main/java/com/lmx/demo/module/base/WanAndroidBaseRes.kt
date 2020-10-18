package com.lmx.demo.module.base

import androidx.annotation.Keep
import com.lmx.base.mvvm.IRes

/**
 * @Desc: 接口返回封装类
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
@Keep
data class WanAndroidBaseRes<T>(
    val errorMsg: String,
    val errorCode: String,
    val `data`: T,
    val version: String
) : IRes<T> {
    override fun getBaseMsg() = errorMsg
    override fun getBaseCode() = errorCode
    override fun getBaseResult() = data
    override fun getBaseVersion() = version
}