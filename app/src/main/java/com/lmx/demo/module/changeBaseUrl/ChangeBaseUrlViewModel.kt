package com.lmx.demo.module.changeBaseUrl;

import androidx.lifecycle.MutableLiveData
import com.lmx.demo.constants.ConstantsKey
import com.lmx.demo.module.api.ApiService
import com.lmx.base.em.RequestDisplay
import com.lmx.base.mvvm.BaseViewModel

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
public class ChangeBaseUrlViewModel : BaseViewModel<ApiService>() {


    public override fun onStart() {
        getWxArticle()
    }

    var result = MutableLiveData<List<ChangeBaseUrlData>>()
    fun getWxArticle() {
        launchOnlyresult(
            //调用接口方法
            block = {
                getApiService().getWxArticle()
            },
            //重试
            reTry = {
                //调用重试的方法
                getWxArticle()
            },
            //成功
            success = {
                //成功回调
                result.value = it
                //成功回调
            },
            currentDomainName = ConstantsKey.WANANDROID_DOMAIN_NAME,
            type = RequestDisplay.REPLACE
        )
    }

}
