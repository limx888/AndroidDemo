package com.lmx.base.http.interceptor

/**
 * @Desc: 接口请求ReturnCode不正确的情况拦截处理
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
interface IReturnCodeErrorInterceptor {
    /**
     * 根据返回的returnCode，判断是否进行拦截
     *
     * @param returnCode
     * @return
     */
    fun intercept(returnCode: String?): Boolean

    /**
     * intercept(String returnCode)方法为true的时候调用该方法
     *
     * @param returnCode
     * @param msg
     */
    fun doWork(returnCode: String?, msg: String?)
}