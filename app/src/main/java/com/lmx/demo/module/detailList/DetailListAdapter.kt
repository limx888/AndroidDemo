package com.lmx.demo.module.detailList

import androidx.databinding.DataBindingUtil
import com.lmx.demo.R
import com.lmx.demo.databinding.ItemDetailListBinding
import com.lmx.base.base.BaseAdapter
import com.lmx.base.view.baseviewholder.BaseViewHolder
import java.util.*

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
class DetailListAdapter : BaseAdapter<DetailListData>(R.layout.item_detail_list, ArrayList()) {

    override fun onItemViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ItemDetailListBinding>(viewHolder.itemView)
    }

    override fun convert(helper: BaseViewHolder, item: DetailListData) {
        val itemListBinding = helper.getBinding<ItemDetailListBinding>()
        if (itemListBinding != null) {
            itemListBinding.detailListData = item
        }
    }

}