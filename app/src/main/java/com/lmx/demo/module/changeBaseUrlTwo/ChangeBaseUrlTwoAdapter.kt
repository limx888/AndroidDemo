package com.lmx.demo.module.changeBaseUrlTwo;

import com.lmx.demo.R;
import androidx.databinding.DataBindingUtil
import com.lmx.demo.databinding.ItemActivityChangeBaseUrlTwoBinding
import com.lmx.base.base.BaseAdapter
import com.lmx.base.view.baseviewholder.BaseViewHolder
import java.util.*

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
public class ChangeBaseUrlTwoAdapter :
    BaseAdapter<ChangeBaseUrlTwoListData>(R.layout.item_activity_change_base_url_two, ArrayList()) {

    override fun onItemViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ItemActivityChangeBaseUrlTwoBinding>(viewHolder.itemView)
    }

    override fun convert(helper: BaseViewHolder, item: ChangeBaseUrlTwoListData) {
        val itemListBinding = helper.getBinding<ItemActivityChangeBaseUrlTwoBinding>()
        if (itemListBinding != null) {
            itemListBinding.changeBaseUrlTwoListData = item
        }
    }

}