package com.lmx.demo.module.detailList

import com.lmx.base.em.RequestDisplay
import com.lmx.base.mvvm.BaseListViewModel
import com.lmx.demo.module.api.ApiService

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
class DetailListViewModel : BaseListViewModel<ApiService>() {

    public override fun onStart() {

    }

    fun searchCity(city: String, pageNo: Int) {
        launchOnlyresult(
            //调用接口方法
            block = {
                getApiService().searDetailchCity(city)
            },
            //重试
            reTry = {
                //调用重试的方法
                searchCity(city, pageNo)
            },
            //成功
            success = {
                //成功回调
            }, type = RequestDisplay.REPLACE, pageNo = pageNo
        )
    }

}