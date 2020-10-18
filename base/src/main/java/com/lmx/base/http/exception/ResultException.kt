package com.lmx.base.http.exception

/**
 * @Desc: 自定义数据返回异常类,制定api接口调用时返回的BaseRes中的泛型T为null或者ListSize为0这两种情况为异常情况
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
class ResultException : Exception {
    /**
     * 数据返回异常
     */
    constructor() : super() {}

    /**
     * 数据返回异常传入错误内容
     * @param msg
     */
    constructor(msg: String?) : super(msg) {}
}