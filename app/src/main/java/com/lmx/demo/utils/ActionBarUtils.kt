package com.lmx.demo.utils

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.lmx.demo.R
import com.lmx.base.utils.StringUtils

/**
 * @Desc: 采取统一的封装的ActionBar
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
class ActionBarUtils {

    companion object {
        /**
         * ToolBar 返回按钮
         *
         * @param toolbar
         * @param backIconId
         * @param listener
         */
        fun setSupportActionBarWithBack(
            toolbar: Toolbar,
            backIconId: Int?,
            listener: View.OnClickListener
        ) {
            toolbar.title = ""
            toolbar.setNavigationIcon(
                if (backIconId == null) {
                    R.mipmap.hulk_back
                } else {
                    backIconId
                }
            )
            toolbar.setNavigationOnClickListener(listener)
        }

        /**
         * 默认位置Title设置
         *
         * @param toolbar
         * @param titleText
         */
        fun setToolBarTitleText(
            toolbar: Toolbar,
            titleText: String?
        ) {
            toolbar.title = titleText
        }

        /**
         * 居中Title设置
         *
         * @param toolbar
         * @param titleText
         */
        fun setCenterTitleText(
            toolbar: Toolbar,
            titleText: String?
        ): TextView? {
            val textView_title = toolbar.findViewById<TextView>(com.lmx.demo.R.id.tv_title)
            textView_title.text = titleText
            return textView_title
        }

        /**
         * 设置是否显示阴影
         *
         * @param toolbar
         * @param show
         */
        fun setToolbarShadow(
            toolbar: Toolbar,
            show: Boolean
        ) {
            val toolbarShadow = toolbar.findViewById<View>(com.lmx.demo.R.id.toolbar_shadow)
            toolbarShadow.visibility = if (show) View.VISIBLE else View.GONE
        }

        /**
         * toolbar设置左侧为文字
         *
         * @param toolbar
         * @param leftText
         * @param listener
         */
        fun setToolBarLeftText(
            toolbar: Toolbar,
            leftText: String?,
            listener: View.OnClickListener?
        ): TextView? {
            val tvLeft = toolbar.findViewById<TextView>(com.lmx.demo.R.id.tv_left)
            if (!StringUtils.isEmpty(leftText)) {
                tvLeft.text = leftText
                tvLeft.visibility = View.VISIBLE
            } else {
                tvLeft.visibility = View.GONE
            }
            tvLeft.setOnClickListener(listener)
            return tvLeft
        }


        /**
         * toolbar设置右侧为文字
         *
         * @param toolbar
         * @param rightText
         * @param listener
         */
        fun setToolBarRightText(
            toolbar: Toolbar,
            rightText: String?,
            listener: View.OnClickListener?
        ): TextView? {
            val tvRight = toolbar.findViewById<TextView>(com.lmx.demo.R.id.tv_right)
            if (!StringUtils.isEmpty(rightText)) {
                tvRight.text = rightText
                tvRight.visibility = View.VISIBLE
            } else {
                tvRight.visibility = View.GONE
            }
            tvRight.setOnClickListener(listener)
            return tvRight
        }
    }
}