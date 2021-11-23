package com.ncs.testonboardingchips

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val data = HashMap<String, List<String>>()
    lateinit var section_chips: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        initView()
    }

    private fun initData() {
        data.put("AAA", listOf("AAA", "AAA", "AAA"))
        data.put("BBBBBB", listOf("BBB", "BBB", "BBB"))
        data.put("CCCC", listOf("CCC", "CCC", "CCC"))
        data.put("DDDDDDDDD", listOf("DDD", "DDD", "DDD"))
        data.put("EE", listOf("EEE", "EEE", "EEE"))
        data.put("FFFFFF", listOf("FFF", "FFF", "FFF"))
        data.put("GGGGGGGGGGG", listOf("GGG", "GGG", "GGG"))
        data.put("HH", listOf("HHH", "HHH", "HHH"))
        data.put("IIIIIIIIIIIIIIIIII", listOf("III", "III", "III"))
        data.put("JJJJJJJJJJJ", listOf("JJJ", "JJJ", "JJJ"))
        data.put("KKKKKK", listOf("KKK", "KKK", "KKK"))
        data.put("LLLL", listOf("LLL", "LLL", "LLL"))
    }

    private fun initView() {
        section_chips = findViewById(R.id.section_chips)

        var row: OBChipRowView
        var detailView: OBChipDetailView

        row = OBChipRowView(this)
        detailView = OBChipDetailView(this)
        detailView.setPadding(5, 5, 5, 5)
        detailView.setBackgroundColor(Color.LTGRAY)
        section_chips.addView(row)
        section_chips.addView(detailView)

        for (title in data.keys) {
            val chipView = creteChip(title, data.get(title))
            if (!row.hasSpaceFor(chipView)) {
                row = OBChipRowView(this)
                detailView = OBChipDetailView(this)
                detailView.setPadding(5, 5, 5, 5)
                detailView.setBackgroundColor(Color.LTGRAY)
                section_chips.addView(row)
                section_chips.addView(detailView)
            }
            updateChip(chipView, detailView)
            row.addChipView(chipView)
        }
    }

    private fun creteChip(
        title: String,
        values: List<String>?,
    ): OBChipView {
        val chipView = OBChipView(this)
        chipView.setTitle(title)
        chipView.textSize = 16.0f
        chipView.values = values

        chipView.setPadding(10, 10, 10, 10)
        chipView.setBackgroundColor(Color.YELLOW)

        return chipView
    }

    private fun updateChip(
        chipView: OBChipView,
        detailView: OBChipDetailView
    ) {
        chipView.detailView = detailView
        chipView.setOnClickListener {
            updateDetails(chipView.getTitle(), chipView.values, detailView)
        }
    }

    private fun updateDetails(
        title: String,
        values: List<String>?,
        detailView: OBChipDetailView
    ) {
        if (title == detailView.title) {
            detailView.title = null
            detailView.visibility = View.GONE
        } else {
            detailView.title = title
            detailView.visibility = View.VISIBLE
            detailView.removeAllViews()
            detailView.removeAllViewsInLayout()
            values?.let {
                for (value in it) {
                    val textView = TextView(this)
                    textView.text = value
                    textView.textSize = 16.0f
                    textView.setPadding(20, 20, 20, 20)
                    detailView.addView(textView)
                }
            }
        }
    }
}