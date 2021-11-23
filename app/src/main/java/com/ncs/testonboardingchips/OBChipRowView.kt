package com.ncs.testonboardingchips

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

class OBChipRowView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    var rowWidth = 400
    val chipViews = ArrayList<OBChipView>()
    val chipMargin = 10

    fun hasSpaceFor(newChipView: OBChipView): Boolean {
        if (chipViews.isEmpty()) {
            return true
        }
        var currentWidth = 0
        for (chip in chipViews) {
            currentWidth += chip.getChipWidth()
        }
        if (currentWidth + newChipView.getChipWidth() <= (rowWidth - chipMargin - chipMargin)) {
            return true
        }
        return false
    }

    fun addChipView(newChipView: OBChipView) {
        chipViews.add(newChipView)
        val layoutParam = LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
        )
        layoutParam.setMargins(chipMargin, chipMargin, chipMargin, chipMargin)
        addView(newChipView, layoutParam)
    }

    init {
        orientation = LinearLayout.HORIZONTAL
    }
}