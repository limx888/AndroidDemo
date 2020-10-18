package com.lmx.demo

import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.lmx.demo.constants.ConstantsKey
import com.lmx.demo.interceptor.RequestHeaderInterceptor
import com.lmx.demo.interceptor.SessionInterceptor
import com.lmx.base.base.BaseApplication
import com.lmx.base.config.BaseConfig
import com.lmx.base.http.ApiClient
import com.lmx.base.utils.Utils
import com.scwang.smartrefresh.header.MaterialHeader
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import okhttp3.logging.HttpLoggingInterceptor

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
class DemoApplication : BaseApplication() {
    override fun initBaseConfig() { //配置项
        BaseConfig.builder() //这里只需要选择设置一个
//            .setRetSuccess(BuildConfig.CODE_SUCCESS)
            .setRetSuccessList(BuildConfig.CODELIST_SUCCESS)
            //设置多baseurl的retcode
            .addRetSuccess(ConstantsKey.WANANDROID_DOMAIN_NAME, BuildConfig.WANANDROID_CODELIST_SUCCESS
            )
            .addRetSuccess(ConstantsKey.GANK_DOMAIN_NAME, BuildConfig.GANK_CODELIST_SUCCESS
            )
            .setBaseUrl(BuildConfig.BASE_URL)
            //设置多baseurl
            .addDomain(ConstantsKey.WANANDROID_DOMAIN_NAME, ConstantsKey.WANANDROID_API)
            .addDomain(ConstantsKey.GANK_DOMAIN_NAME, ConstantsKey.GANK_API)
            .setLogOpen(BuildConfig.OPEN_LOG)
            .setArouterOpen(BuildConfig.OPEN_AROUTER)
            .addOkHttpInterceptor(RequestHeaderInterceptor()) //请求头拦截器
            .addOkHttpInterceptor(
                BuildConfig.OPEN_LOG,
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            ) //okhttp请求日志开关+消息拦截器.md
            .addRetCodeInterceptors(SessionInterceptor()) // returnCode非正常态拦截器
            .setRetrofit(
                ApiClient.getInstance().getRetrofit(
                    ApiClient.getInstance().getOkHttpClient(
                        BaseConfig.getOkHttpInterceptors()
                    )
                )
            )
            .build()
        //application 上下文
        Utils.init(this)
        //ARouter的初始化
        initArouter()
        //SmartRefreshLayout的统一设置
        initSmartRefreshLayout()
    }

    /**
     * ARouter的初始化
     */
    private fun initArouter() {
        //测试环境
        if (BuildConfig.OPEN_LOG) {
            ARouter.openLog() // 打印日志
            ARouter.openDebug() // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this)
    }

    /**
     * SmartRefreshLayout的统一设置
     */
    private fun initSmartRefreshLayout() {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator({ context: Context, refreshLayout: RefreshLayout ->
            //            refreshLayout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white)
            return@setDefaultRefreshHeaderCreator MaterialHeader(context)
        })

        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator({ context: Context, refreshLayout: RefreshLayout ->
            return@setDefaultRefreshFooterCreator ClassicsFooter(context).setDrawableSize(20f)
        })
    }

}