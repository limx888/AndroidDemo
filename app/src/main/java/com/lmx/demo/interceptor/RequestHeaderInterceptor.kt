package com.lmx.demo.interceptor

import com.lmx.base.http.interceptor.BaseUrlInterceptor
import okhttp3.Headers

/**
 * @Desc: 请求头拦截器,如果需要设置多baseurl得继承BaseUrlInterceptor去写
 *                                   单baseurl直接继承Interceptor去写
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
class RequestHeaderInterceptor : BaseUrlInterceptor() {

    override fun addHeaders(): Headers {
        return Headers.Builder()
            .add("app_id", "wpkxpsejggapivjf")
            .add("app_secret", "R3FzaHhSSXh4L2tqRzcxWFBmKzBvZz09")
            .build()
    }


//    //单baseurl的写法参考 统一请求头的封装根据自身项目添加
//    @Throws(IOException::class)
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val request = chain.request()
//        val authorised: Request
//        val headers = Headers.Builder()
//            .add("app_id", "wpkxpsejggapivjf")
//            .add("app_secret", "R3FzaHhSSXh4L2tqRzcxWFBmKzBvZz09")
//            .build()
//        authorised = request.newBuilder().headers(headers).build()
//        return chain.proceed(authorised)
//    }
}