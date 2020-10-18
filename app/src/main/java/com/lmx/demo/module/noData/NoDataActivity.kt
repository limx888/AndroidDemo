package com.lmx.demo.module.noData

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import com.lmx.demo.R
import com.lmx.demo.constants.ARouterUri
import com.lmx.demo.databinding.ActivityNodataBinding
import com.lmx.demo.utils.ActionBarUtils
import com.lmx.base.base.BaseActivity
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.activity_single.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
@Route(path = ARouterUri.NoDataActivity)
class NoDataActivity : BaseActivity<NoDataViewModel, ActivityNodataBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_nodata
    }

    override fun getReplaceView(): View {
        return layout
    }

    override fun init(savedInstanceState: Bundle?) {
        //ActionBar相关设置
        ActionBarUtils.setSupportActionBarWithBack(toolbar, null, View.OnClickListener {
            onBackPressed()
        })
        ActionBarUtils.setToolBarTitleText(toolbar, "无数据展示界面")
        //请求接口
        mViewModel.searchCity("广德")
        //接口请求的数据变化
        mViewModel.result.observe(this, Observer {
            mBinding?.listDataS = it
            mBinding?.listData = it[0]
        })
    }

    /**
     * 设置SmartRefreshLayout
     */
    override fun getSmartRefreshLayout(): SmartRefreshLayout? {
        return null
    }

    override fun refreshData() {

    }

}