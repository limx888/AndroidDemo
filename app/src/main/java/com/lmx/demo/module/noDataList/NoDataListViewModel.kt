package com.lmx.demo.module.noDataList

import com.lmx.demo.module.api.ApiService
import com.lmx.base.em.RequestDisplay
import com.lmx.base.mvvm.BaseListViewModel

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
class NoDataListViewModel : BaseListViewModel<ApiService>() {

    public override fun onStart() {
    }

    public fun searchCity(value: String, pageNo: Int) {
        launchOnlyresult(
            //调用接口方法
            block = {
                getApiService().searchCity(value)
            },
            //重试
            reTry = {
                //调用重试的方法
                searchCity(value, pageNo)
            },
            //成功
            success = {
                //成功回调
                //通知ui刷新
            }, type = RequestDisplay.REPLACE, pageNo = pageNo
        )
    }


}