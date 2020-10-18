package com.lmx.demo.module.single

import androidx.lifecycle.MutableLiveData
import com.lmx.demo.module.api.ApiService
import com.lmx.base.em.RequestDisplay
import com.lmx.base.mvvm.BaseViewModel

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
class SingleViewModel : BaseViewModel<ApiService>() {

    public override fun onStart() {
        cityList()
    }

    var result = MutableLiveData<List<SingleData>>()
    private fun cityList() {
        launchOnlyresult(
            //调用接口方法
            block = {
                getApiService().getCityList()
            },
            //重试
            reTry = {
                //调用重试的方法
                cityList()
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