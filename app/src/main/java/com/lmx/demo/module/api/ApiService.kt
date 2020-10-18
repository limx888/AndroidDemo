package com.lmx.demo.module.api

import com.lmx.demo.constants.ConstantsKey
import com.lmx.demo.module.changeBaseUrl.ChangeBaseUrlData
import com.lmx.demo.module.base.BaseRes
import com.lmx.demo.module.base.GankBaseRes
import com.lmx.demo.module.base.WanAndroidBaseRes
import com.lmx.demo.module.changeBaseUrlTwo.ChangeBaseUrlTwoListData
import com.lmx.demo.module.dashboard.DashboardData
import com.lmx.demo.module.detailList.DetailListData
import com.lmx.demo.module.list.ListData
import com.lmx.demo.module.multi.MultiListData
import com.lmx.demo.module.notifications.NotificationsData
import com.lmx.demo.module.refreshSingle.RefreshSingleData
import com.lmx.demo.module.single.SingleData
import com.lmx.base.config.BaseConfig
import com.lmx.base.config.BaseConfig.IDENTIFICATION_PATH_SIZE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * @Desc: 这里用的接口来自https://github.com/MZCretin/RollToolsApi，感谢MZCretin
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
interface ApiService {

    @GET("api/address/list")
    suspend fun getCityList(): BaseRes<List<SingleData>>

    @GET("api/address/list")
    suspend fun getRefreshCityList(): BaseRes<List<RefreshSingleData>>

    @GET("api/address/search?type=0&")
    suspend fun searchCity(@Query("value") value: String): BaseRes<List<ListData>>

    @GET("api/address/search?type=0&")
    suspend fun searDetailchCity(@Query("value") value: String): BaseRes<List<DetailListData>>

    @GET("api/address/list")
    suspend fun getNotificationsCityList(): BaseRes<List<NotificationsData>>

    @GET("api/address/search?type=0&")
    suspend fun searDashboardchCity(@Query("value") value: String): BaseRes<List<DashboardData>>

    @GET("api/address/list")
    suspend fun getMultiList(): BaseRes<List<MultiListData>>

    /**
     * 玩 Android的api
     */
    @Headers(BaseConfig.DOMAIN_NAME_HEADER + ConstantsKey.WANANDROID_DOMAIN_NAME)
    @GET("wxarticle/chapters/json" + IDENTIFICATION_PATH_SIZE + 0)
    suspend fun getWxArticle(): WanAndroidBaseRes<List<ChangeBaseUrlData>>

    /**
     * gank的api
     */
    @Headers(BaseConfig.DOMAIN_NAME_HEADER + ConstantsKey.GANK_DOMAIN_NAME)
    @GET("api/v2/categories/GanHuo" + IDENTIFICATION_PATH_SIZE + 0)
    suspend fun getCategories(): GankBaseRes<List<ChangeBaseUrlTwoListData>>


}