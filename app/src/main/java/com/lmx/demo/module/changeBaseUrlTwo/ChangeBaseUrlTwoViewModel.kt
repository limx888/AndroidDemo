package com.lmx.demo.module.changeBaseUrlTwo;

import com.lmx.demo.constants.ConstantsKey
import com.lmx.demo.module.api.ApiService
import com.lmx.base.em.RequestDisplay
import com.lmx.base.mvvm.BaseListViewModel

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
public class ChangeBaseUrlTwoViewModel : BaseListViewModel<ApiService>() {


    public override fun onStart() {
        getCategories(1)
    }

    fun getCategories(pageNo: Int) {
        launchOnlyresult(
            //调用接口方法
            block = {
                getApiService().getCategories()
            },
            //重试
            reTry = {
                //调用重试的方法
                getCategories(pageNo)
            },
            //成功
            success = {
                //成功回调
            },
            currentDomainName = ConstantsKey.GANK_DOMAIN_NAME,
            type = RequestDisplay.REPLACE,
            pageNo = pageNo
        )
    }

}
