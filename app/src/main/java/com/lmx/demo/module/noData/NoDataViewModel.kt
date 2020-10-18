package com.lmx.demo.module.noData

import androidx.lifecycle.MutableLiveData
import com.lmx.demo.module.api.ApiService
import com.lmx.demo.module.list.ListData
import com.lmx.base.em.RequestDisplay
import com.lmx.base.mvvm.BaseViewModel

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
class NoDataViewModel : BaseViewModel<ApiService>() {

    public override fun onStart() {
    }

    var result = MutableLiveData<List<ListData>>()
    public fun searchCity(value: String) {
        launchOnlyresult(
            //调用接口方法
            block = {
                getApiService().searchCity(value)
            },
            //重试
            reTry = {
                //调用重试的方法
                searchCity(value)
            },
            //成功
            success = {
                //成功回调
                result.value = it
                //通知ui刷新
            }, type = RequestDisplay.REPLACE
        )
    }


}