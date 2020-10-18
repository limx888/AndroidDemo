package com.lmx.demo.module.multi;

import com.lmx.demo.module.api.ApiService
import com.lmx.base.em.RequestDisplay
import com.lmx.base.mvvm.BaseListViewModel

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
public class MultiViewModel : BaseListViewModel<ApiService>() {


    public override fun onStart() {

    }

    fun getMultiList(pageNo: Int) {
        launchOnlyresult(
            //调用接口方法
            block = {
                getApiService().getMultiList()
            },
            //重试
            reTry = {
                //调用重试的方法
                getMultiList(pageNo)
            },
            //成功
            success = {
                //成功回调
            }, type = RequestDisplay.REPLACE, pageNo = pageNo
        )
    }

}
