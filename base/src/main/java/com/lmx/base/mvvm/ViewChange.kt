package com.lmx.base.mvvm

import com.lmx.base.http.SingleLiveEvent

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
class ViewChange {
    //加载的loading
    val showLoading by lazy { SingleLiveEvent<String>() }
    //对话框显示
    val showDialogProgress by lazy { SingleLiveEvent<String>() }
    //对话框消失
    val dismissDialog by lazy { SingleLiveEvent<String>() }
    //toast
    val showToast by lazy { SingleLiveEvent<String>() }
    //tip提示
    val showTips by lazy { SingleLiveEvent<String>() }
    //无数据
    val showEmpty by lazy { SingleLiveEvent<String>() }
    //网络错误
    val showNetworkError by lazy { SingleLiveEvent<String>() }
    //是否恢复了
    val restore by lazy { SingleLiveEvent<Void>() }
    //刷新结束
    val refreshComplete by lazy { SingleLiveEvent<Void>() }
}