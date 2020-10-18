package com.lmx.demo.module.custom

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.lmx.demo.R
import com.lmx.demo.constants.ARouterUri
import com.lmx.demo.constants.ConstantsKey
import com.lmx.demo.databinding.ActivityListBinding
import com.lmx.demo.module.list.ListAdapter
import com.lmx.demo.module.list.ListData
import com.lmx.demo.utils.ActionBarUtils
import com.lmx.demo.view.MyVaryViewHelperController
import com.lmx.base.base.BaseListActivity
import com.lmx.base.view.IVaryViewHelperController
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
@Route(path = ARouterUri.CustomActivity)
public class CustomActivity :
    BaseListActivity<CustomViewModel, ActivityListBinding, ListAdapter, ListData>() {

    @Autowired(name = ConstantsKey.CustomKey)
    @JvmField
    var customValue: String? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_list
    }

    override fun getReplaceView(): View {
        return smartRefreshLayout
    }

    override fun init(savedInstanceState: Bundle?) {
        showToast("这是Arouter传递过来的值: " + customValue)
        //ActionBar相关设置
        ActionBarUtils.setSupportActionBarWithBack(toolbar, null, View.OnClickListener {
            onBackPressed()
        })
        ActionBarUtils.setToolBarTitleText(toolbar, "自定义view展示,这里只修改了自定义的loading")
        //请求接口
        mViewModel.searchCity("中国", 1)
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
        adapter = ListAdapter()
    }

    /**
     * 自定义相关不同状态展示的view,这里只是修改了loading的效果不同，可根据每个项目的实际情况
     * @return
     */
    override fun initVaryViewHelperController(): IVaryViewHelperController? {
        return MyVaryViewHelperController(getReplaceView())
    }


}