package com.lmx.demo.module.noDataList

import androidx.databinding.DataBindingUtil
import com.lmx.demo.R
import com.lmx.demo.databinding.ItemListBinding
import com.lmx.demo.module.list.ListData
import com.lmx.base.base.BaseAdapter
import com.lmx.base.view.baseviewholder.BaseViewHolder
import java.util.*

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
class NoDataListAdapter : BaseAdapter<ListData>(R.layout.item_list, ArrayList()) {

    override fun onItemViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ItemListBinding>(viewHolder.itemView)
    }

    override fun convert(helper: BaseViewHolder, item: ListData) {
        val itemListBinding = helper.getBinding<ItemListBinding>()
        if (itemListBinding != null) {
            itemListBinding.listData = item
        }
    }

}