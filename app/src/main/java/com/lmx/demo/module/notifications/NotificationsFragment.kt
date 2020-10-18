package com.lmx.demo.module.notifications

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.lmx.demo.R
import com.lmx.demo.databinding.FragmentNotificationsBinding
import com.lmx.base.base.BaseFragment
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.fragment_notifications.*

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
class NotificationsFragment : BaseFragment<NotificationsViewModel, FragmentNotificationsBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_notifications
    }

    override fun getReplaceView(): View {
        return layout_notifications
    }

    override fun init(savedInstanceState: Bundle?) {
        mViewModel.onStart()
        mViewModel.result.observe(
            this, Observer {
                mBinding?.notificationsData = it[0]
            })
    }

    override fun getSmartRefreshLayout(): SmartRefreshLayout? {
        return null
    }

    override fun refreshData() {

    }

}