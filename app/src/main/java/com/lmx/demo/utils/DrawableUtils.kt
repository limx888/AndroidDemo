package com.lmx.demo.utils

import android.graphics.drawable.Drawable
import android.widget.TextView

/**
 * @Desc:
 * @Author: limingxia
 * @Date: Created on 2020/9/27 9:19 AM
 * @Modified By:
 */
class DrawableUtils {
    companion object {
        fun setDrawableTop(
            tv: TextView,
            drawable: Drawable
        ) {
            drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
            tv.setCompoundDrawables(null, drawable, null, null)
        }

        fun setDrawableLeft(
            tv: TextView,
            drawable: Drawable
        ) {
            drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
            tv.setCompoundDrawables(drawable, null, null, null)
        }

        fun setDrawableRight(
            tv: TextView,
            drawable: Drawable
        ) {
            drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
            tv.setCompoundDrawables(null, null, drawable, null)
        }

        fun setDrawableNull(tv: TextView) {
            tv.setCompoundDrawables(null, null, null, null)
        }
    }
}