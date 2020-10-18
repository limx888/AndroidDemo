package com.lmx.demo.module.home

import androidx.lifecycle.MutableLiveData
import com.lmx.demo.module.api.ApiService
import com.lmx.base.mvvm.BaseViewModel

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
class HomeViewModel : BaseViewModel<ApiService>() {

    var result = MutableLiveData<String>()

    public override fun onStart() {
        result.value = "This is home fragment"
    }

    public fun refreshData(){
        result.value = "刷新得到新数据"
        //恢复原先
        viewChange.restore.call()
    }

}