package com.ncs.testonboardingchips

import android.content.Context
import android.util.AttributeSet

class OBChipView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : androidx.appcompat.widget.AppCompatTextView(context, attrs, defStyle) {

    private lateinit var title: String

    var values: List<String>? = null
    lateinit var detailView: OBChipDetailView

    fun setTitle(title: String) {
        this.title = title
        setText(title)
    }

    fun getTitle(): String {
        return title
    }

    fun getChipWidth(): Int {
        return (title.length * 10) + 20 //addition 10 for padding and margin
    }

}