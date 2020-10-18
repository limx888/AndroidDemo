package com.lmx.demo.module.refreshSingle

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import com.lmx.demo.R
import com.lmx.demo.constants.ARouterUri
import com.lmx.demo.databinding.ActivityRefreshSingleBinding
import com.lmx.demo.utils.ActionBarUtils
import com.lmx.base.base.BaseActivity
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.activity_refresh_single.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
@Route(path = ARouterUri.RefreshSingleActivity)
class RefreshSingleActivity : BaseActivity<RefreshSingleViewModel, ActivityRefreshSingleBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_refresh_single
    }

    override fun getReplaceView(): View {
        return smartRefreshLayout
    }

    override fun init(savedInstanceState: Bundle?) {
        //ActionBar相关设置
        ActionBarUtils.setSupportActionBarWithBack(toolbar, null, View.OnClickListener {
            onBackPressed()
        })
        ActionBarUtils.setToolBarTitleText(toolbar, "单数据带刷新功能的展示界面")
        //请求接口
        mViewModel.onStart()
        //接口请求的数据变化
        mViewModel.result.observe(this, Observer {
            mBinding?.refreshSingleDataS = it
            mBinding?.refreshSingleData = it[0]
        })
    }

    /**
     * 设置SmartRefreshLayout
     */
    override fun getSmartRefreshLayout(): SmartRefreshLayout? {
        return smartRefreshLayout
    }

    override fun refreshData() {
        //请求接口
        mViewModel.onStart()
    }

}