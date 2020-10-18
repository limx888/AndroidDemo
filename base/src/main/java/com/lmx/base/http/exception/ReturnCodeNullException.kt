package com.lmx.base.http.exception

/**
 * @Desc: 多baseurl时，未设置对应的成功returnCode
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
class ReturnCodeNullException
/**
 * 未设置对应的成功returnCode提示
 *
 * @param returnCode
 * @param msg
 */(val returnCode: String?, msg: String?) :
    Exception(msg)