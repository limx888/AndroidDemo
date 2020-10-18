package com.lmx.demo.module.multi;

import androidx.databinding.DataBindingUtil
import com.lmx.demo.R
import com.lmx.demo.databinding.ItemActivityMulti2Binding
import com.lmx.demo.databinding.ItemActivityMultiBinding
import com.lmx.base.base.BaseMultiAdapter
import com.lmx.base.view.baseviewholder.BaseViewHolder
import java.util.*

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
public class MultiAdapter : BaseMultiAdapter<MultiListData>(ArrayList()) {


    override fun onItemViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        when (viewType) {
            MultiListData.type_1 -> {
                DataBindingUtil.bind<ItemActivityMultiBinding>(viewHolder.itemView)
            }
            MultiListData.type_2 -> {
                DataBindingUtil.bind<ItemActivityMulti2Binding>(viewHolder.itemView)
            }
        }
    }

    /**
     * 布局
     */
    override fun convert(helper: BaseViewHolder, item: MultiListData) {
        when (item.itemType) {
            MultiListData.type_1 -> {
                val itemListBinding = helper.getBinding<ItemActivityMultiBinding>()
                if (itemListBinding != null) {
                    itemListBinding.multiListData = item
                }
            }
            MultiListData.type_2 -> {
                val itemListBinding = helper.getBinding<ItemActivityMulti2Binding>()
                if (itemListBinding != null) {
                    itemListBinding.multiListData = item
                }
            }
        }
    }

    override fun addItemType() {
        addItemType(MultiListData.type_1, R.layout.item_activity_multi)
        addItemType(MultiListData.type_2, R.layout.item_activity_multi2)
    }

}