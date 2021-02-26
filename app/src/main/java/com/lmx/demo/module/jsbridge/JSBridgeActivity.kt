package com.lmx.demo.module.jsbridge

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebChromeClient
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import com.alibaba.android.arouter.facade.annotation.Route
import com.lmx.base.base.BaseActivity
import com.lmx.demo.R
import com.lmx.demo.constants.ARouterUri
import com.lmx.demo.module.main.MainViewModel
import com.lmx.demo.utils.ActionBarUtils
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.activity_jsbridge.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.main_layout
import kotlinx.android.synthetic.main.toolbar.*

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/2/25 9:19 AM
 * @Modified By:
 */

@Route(path = ARouterUri.JSBridgeActivity)
class JSBridgeActivity : BaseActivity<MainViewModel, ViewDataBinding>() {
    private val url = "file:///android_asset/business.html"
    private val TAG = "JSBridgeActivity"

    override fun getLayoutId(): Int {
        return R.layout.activity_jsbridge
    }

    override fun getReplaceView(): View {
        return main_layout
    }

    override fun init(savedInstanceState: Bundle?) {
        //ActionBar相关设置
        ActionBarUtils.setSupportActionBarWithBack(toolbar, null, View.OnClickListener {
            onBackPressed()
        })
        ActionBarUtils.setToolBarTitleText(toolbar, "H5页面与原生数据交互")

        initWebView()
    }

    /**
     * 初始化 WebView
     */
    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() {
        Log.i(TAG, "initBridgeWebView...")

        main_wv.loadUrl(url)

        return_data.setOnClickListener {
            main_wv.callHandler("businessScanRes", "我是原生传递的参数") { data ->

                Log.i(
                    TAG,
                    "reponse data from js $data" + ",Thread is " + Thread.currentThread().name
                )
                Toast.makeText(this@JSBridgeActivity, data, Toast.LENGTH_SHORT).show()
            }
        }
        //local register bridge
        main_wv.addHandlerLocal("businessScan", object : BridgeHandler() {
            override fun handler(context: Context?, data: String?, function: CallBackFunction?) {
                Log.i(
                    TAG,
                    "YY reponse data from js $data" + ",Thread is " + Thread.currentThread().name
                )
                Toast.makeText(this@JSBridgeActivity, data, Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun getSmartRefreshLayout(): SmartRefreshLayout? {
        return null
    }

    override fun refreshData() {

    }
}
