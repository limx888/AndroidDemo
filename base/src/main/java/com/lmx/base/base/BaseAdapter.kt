package com.lmx.base.base

import com.chad.library.adapter.base.BaseQuickAdapter
import com.lmx.base.view.baseviewholder.BaseViewHolder

/**
 * @Desc: 继承BaseQuickAdapter，自定义通用方法
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
abstract class BaseAdapter<T>(layoutResId: Int, data: MutableList<T>) :

    BaseQuickAdapter<T, BaseViewHolder>(layoutResId, data) {

    open fun clearData() {
        data.clear()
        notifyDataSetChanged()
    }

}