package com.lmx.demo.module.detailList


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.lmx.demo.R
import com.lmx.demo.constants.ARouterUri
import com.lmx.demo.databinding.ActivityDetailListBinding
import com.lmx.demo.utils.ActionBarUtils
import com.lmx.base.base.BaseListActivity
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
@Route(path = ARouterUri.DetailListActivity)
class DetailListActivity :
    BaseListActivity<DetailListViewModel, ActivityDetailListBinding, DetailListAdapter, DetailListData>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_detail_list
    }

    override fun getReplaceView(): View {
        return smartRefreshLayout
    }

    override fun init(savedInstanceState: Bundle?) {
        //ActionBar相关设置
        ActionBarUtils.setSupportActionBarWithBack(toolbar, null, View.OnClickListener {
            onBackPressed()
        })
        ActionBarUtils.setToolBarTitleText(toolbar, "DetailList带头部底部的数据展示界面")
        //请求接口
        mViewModel.searchCity("中国", 1)
        //增加头部
        adapter?.addHeaderView(LayoutInflater.from(this).inflate(R.layout.head_detail, null))
        //增加底部
        adapter?.addFooterView(LayoutInflater.from(this).inflate(R.layout.footer_detail, null))
    }

    /**
     * list相关方法
     */
    override fun loadPageListData(pageNo: Int) {
        mViewModel.searchCity("中国", pageNo)
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
        adapter = DetailListAdapter()
    }

}