package com.lmx.demo.module.main

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.jeremyliao.liveeventbus.LiveEventBus
import com.lmx.demo.R
import com.lmx.demo.constants.ARouterUri
import com.lmx.demo.constants.ConstantsKey
import com.lmx.demo.constants.LiveEventBusKey
import com.lmx.demo.module.dialog.DialogFragment
import com.lmx.demo.utils.ActionBarUtils
import com.lmx.base.base.BaseActivity
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
@Route(path = ARouterUri.MainActivity)
class MainActivity : BaseActivity<MainViewModel, ViewDataBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getReplaceView(): View {
        return main_layout
    }

    override fun init(savedInstanceState: Bundle?) {
        ActionBarUtils.setToolBarTitleText(toolbar, "AndroidDemo项目展示")
        //single展示
        tv_single.setOnClickListener {
            //            startActivity(Intent(hulkActivity, SingleActivity::class.java))
            ARouter.getInstance().build(ARouterUri.SingleActivity).navigation()
        }
        //single刷新功能展示
        tv_refresh_single.setOnClickListener {
            //            startActivity(Intent(hulkActivity, RefreshSingleActivity::class.java))
            ARouter.getInstance().build(ARouterUri.RefreshSingleActivity).navigation()
        }
        //list展示
        tv_list.setOnClickListener {
            //            startActivity(Intent(hulkActivity, ListActivity::class.java))
            ARouter.getInstance().build(ARouterUri.ListActivity).navigation()
        }
        //Detaillist展示
        tv_detail_list.setOnClickListener {
            //            startActivity(Intent(hulkActivity, DetailListActivity::class.java))
            ARouter.getInstance().build(ARouterUri.DetailListActivity).navigation()
        }
        //Detaillist展示
        tv_main2.setOnClickListener {
            //            startActivity(Intent(hulkActivity, Main2Activity::class.java))
            ARouter.getInstance().build(ARouterUri.Main2Activity).navigation()
        }
        //dialog
        tv_dialog.setOnClickListener {
            val dialogFragment = DialogFragment()
            val bundle = Bundle()
            bundle.putString(ConstantsKey.CommonTitle, "提示标题")
            bundle.putString(ConstantsKey.CommonDesc, "提示内容")
            bundle.putString(ConstantsKey.CommonLeft, "取消")
            bundle.putString(ConstantsKey.CommonRight, "确定")
            bundle.putString(ConstantsKey.CommonRemind, "不再提醒")
            bundle.putBoolean(ConstantsKey.CommonExternalArea, true)
            dialogFragment.setArguments(bundle)
            dialogFragment.setOnLeftRightClickListener(
                onLeftClick = { isRemind ->
                    showToast("点击了左边按钮，是否不再提醒" + isRemind)
                },
                onRightClick = { isRemind ->
                    showToast("点击了右边按钮，是否不再提醒" + isRemind)
                })
            dialogFragment.show(supportFragmentManager, DialogFragment::class.java.getName())
        }
        //无数据
        tv_nodata.setOnClickListener {
            //            startActivity(Intent(hulkActivity, NoDataActivity::class.java))
            ARouter.getInstance().build(ARouterUri.NoDataActivity).navigation()
        }
        //无数据list
        tv_nodatalist.setOnClickListener {
            //            startActivity(Intent(hulkActivity, NoDataListActivity::class.java))
            ARouter.getInstance().build(ARouterUri.NoDataListActivity).navigation()
        }
        //自定义view替换
        tv_custom.setOnClickListener {
            //            startActivity(Intent(hulkActivity, CustomActivity::class.java))
            ARouter.getInstance().build(ARouterUri.CustomActivity)
                .withString(ConstantsKey.CustomKey, "测试Arouter")
                .navigation()
        }
        //多布局展示
        tv_multi.setOnClickListener {
            //            startActivity(Intent(hulkActivity, MultiActivity::class.java))
            ARouter.getInstance().build(ARouterUri.MultiActivity).navigation()
        }
        //EventBus
        tv_event.setOnClickListener {
            //            startActivity(Intent(hulkActivity, EventBusActivity::class.java))
            ARouter.getInstance().build(ARouterUri.EventBusActivity).navigation()
            //传递参数
            LiveEventBus
                .get(LiveEventBusKey.AACKey)
                .postDelay("我是一个EventBus测试",1000)
        }
        //多个baseurl
        tv_more.setOnClickListener {
            ARouter.getInstance().build(ARouterUri.ChangeBaseUrlActivity).navigation()
        }
        //多个baseurl
        tv_more2.setOnClickListener {
            ARouter.getInstance().build(ARouterUri.ChangeBaseUrlTwoActivity).navigation()
        }

        //jsbridge H5与原生数据交互
        tv_jsbridge.setOnClickListener {
            ARouter.getInstance().build(ARouterUri.JSBridgeActivity).navigation()
        }
    }

    override fun getSmartRefreshLayout(): SmartRefreshLayout? {
        return null
    }

    override fun refreshData() {

    }

}
