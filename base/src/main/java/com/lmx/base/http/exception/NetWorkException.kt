package com.lmx.base.http.exception

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
class NetWorkException : Exception {
    /**
     * 网络错误
     */
    constructor() : super() {}

    /**
     * 网络错误传入错误内容
     * @param msg
     */
    constructor(msg: String?) : super(msg) {}
}