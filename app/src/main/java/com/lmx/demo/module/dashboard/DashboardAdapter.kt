package com.lmx.demo.module.dashboard

import androidx.databinding.DataBindingUtil
import com.lmx.demo.R
import com.lmx.demo.databinding.ItemDashboardBinding
import com.lmx.base.base.BaseAdapter
import com.lmx.base.view.baseviewholder.BaseViewHolder
import java.util.*

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
class DashboardAdapter : BaseAdapter<DashboardData>(R.layout.item_dashboard, ArrayList()) {

    override fun onItemViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        DataBindingUtil.bind<ItemDashboardBinding>(viewHolder.itemView)
    }

    override fun convert(helper: BaseViewHolder, item: DashboardData) {
        val itemListBinding = helper.getBinding<ItemDashboardBinding>()
        if (itemListBinding != null) {
            itemListBinding.dashboardData = item
        }
    }

}