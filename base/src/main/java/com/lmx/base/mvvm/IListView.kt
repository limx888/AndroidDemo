package com.lmx.base.mvvm

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
interface IListView<T> : IView {
    /**
     * 刷新结束
     */
    fun refreshComplete()

    /**
     * 显示数据
     * @param datas
     * @param pageNum
     */
    fun showListData(datas: List<T>?, pageNum: Int)
}