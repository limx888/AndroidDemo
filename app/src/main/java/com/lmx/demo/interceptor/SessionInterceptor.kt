package com.lmx.demo.interceptor

import com.lmx.base.http.interceptor.IReturnCodeErrorInterceptor

/**
 * @Desc: returnCode返回session_100 拦截处理
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
class SessionInterceptor : IReturnCodeErrorInterceptor {
    //和接口定义互踢的相关参数返回，然后在doWork方法进行跳转
    override fun intercept(returnCode: String?): Boolean {
        return "-100" == returnCode
    }

    override fun doWork(returnCode: String?, msg: String?) {

    }

}