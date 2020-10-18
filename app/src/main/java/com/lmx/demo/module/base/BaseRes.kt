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
data class BaseRes<T>(
    val msg: String,
    val code: String,
    val `data`: T,
    val version: String
) : IRes<T> {
    override fun getBaseMsg() = msg
    override fun getBaseCode() = code
    override fun getBaseResult() = data
    override fun getBaseVersion() = version
}