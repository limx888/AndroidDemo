package com.lmx.demo.module.home

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.lmx.demo.R
import com.lmx.base.base.BaseFragment
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
class HomeFragment : BaseFragment<HomeViewModel, ViewDataBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun getReplaceView(): View {
        return layout_home
    }

    override fun init(savedInstanceState: Bundle?) {
        mViewModel.onStart()
        mViewModel.result.observe(viewLifecycleOwner, Observer<String?> { s -> text_home.text = s })
    }

    override fun getSmartRefreshLayout(): SmartRefreshLayout? {
        return smartRefreshLayout
    }

    override fun refreshData() {
        mViewModel.refreshData()
    }

}