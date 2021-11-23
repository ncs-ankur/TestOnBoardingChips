package com.ncs.testonboardingchips

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout

class OBChipDetailView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    var title: String? = null

    init {
        orientation = LinearLayout.HORIZONTAL
        visibility = View.GONE
    }
}