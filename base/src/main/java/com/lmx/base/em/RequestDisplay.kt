package com.lmx.base.em

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
enum class RequestDisplay {
    NULL, TOAST, REPLACE
    // NULL //无交互
    // TOAST //接口开始showDialogProgress()---->>接口结束 dismissDialog() 错误Toast
    //  REPLACE //接口开始showLoading()---->>接口结束 :成功：restore(),失败：showError();
}