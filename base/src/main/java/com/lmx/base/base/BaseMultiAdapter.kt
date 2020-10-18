package com.lmx.base.base

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.lmx.base.view.baseviewholder.BaseViewHolder

/**
 * @Desc: 继承BaseQuickAdapter，自定义通用方法
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
abstract class BaseMultiAdapter<T : MultiItemEntity>(data: MutableList<T>) :

    BaseMultiItemQuickAdapter<T, BaseViewHolder>(data) {

    abstract fun addItemType()

    init {
        addItemType()
    }

    open fun clearData() {
        data.clear()
        notifyDataSetChanged()
    }

}