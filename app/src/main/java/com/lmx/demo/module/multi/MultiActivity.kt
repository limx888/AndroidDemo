package com.lmx.demo.module.multi;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route

import com.lmx.demo.R;
import com.lmx.demo.constants.ARouterUri
import com.lmx.base.base.BaseListActivity;
import com.lmx.demo.databinding.ActivityMultiBinding
import com.lmx.demo.utils.ActionBarUtils
import com.scwang.smartrefresh.layout.SmartRefreshLayout

import kotlinx.android.synthetic.main.activity_multi.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
@Route(path = ARouterUri.MultiActivity)
public class MultiActivity :
    BaseListActivity<MultiViewModel, ActivityMultiBinding, MultiAdapter, MultiListData>() {


    override fun getLayoutId(): Int {
        return R.layout.activity_multi;
    }

    override fun getReplaceView(): View {
        return activity_multi
    }

    override fun init(savedInstanceState: Bundle?) {
        //ActionBar相关设置
        ActionBarUtils.setSupportActionBarWithBack(toolbar, null, View.OnClickListener {
            onBackPressed()
        })
        ActionBarUtils.setToolBarTitleText(toolbar, "多布局的展示")
        mViewModel.getMultiList(1)

    }

    /**
     * list相关方法
     */
    override fun loadPageListData(pageNo: Int) {
        mViewModel.getMultiList(2)
    }

    override fun getSmartRefreshLayout(): SmartRefreshLayout {
        return smartRefreshLayout
    }

    override fun getRecyclerView(): RecyclerView {
        return recyclerView
    }

    override fun getLayoutManager(): RecyclerView.LayoutManager {
        return LinearLayoutManager(this)
    }

    override fun getAdapter() {
        adapter = MultiAdapter()
    }
}
