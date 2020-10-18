package com.lmx.base.mvvm

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
interface IRes<T> {
    fun getBaseMsg(): String
    fun getBaseCode(): String
    fun getBaseResult(): T
    fun getBaseVersion(): String
}