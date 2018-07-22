package org.goldenage.com.goldenage

import android.content.Intent
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        graphSettting()
        recyclerViewSetting()

        button_setting.setOnClickListener {
            startActivity(Intent(this, SettingActivity::class.java))
        }
    }

    fun recyclerViewSetting()
    {
        var dividerItemDeco = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        dividerItemDeco.setDrawable(getDrawable(R.drawable.split_line))

        recyclerView.adapter = ItemRecyclerViewAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(dividerItemDeco)
    }

    fun graphSettting()
    {
        var entries = mutableListOf<Entry>()
        entries.add(Entry(0f, 0f))
        entries.add(Entry(1f, 3f))
        entries.add(Entry(2f, -3f))
        entries.add(Entry(3f, 5f))
        entries.add(Entry(4f, 0f))
        entries.add(Entry(5f, 2f))
        entries.add(Entry(6f, 7f))
        entries.add(Entry(7f, 9f))
        entries.add(Entry(8f, -2f))
        entries.add(Entry(9f, 0f))

        chart.post {
            val paint = chart.getRenderer().getPaintRender()
            val height = chart.height

            val linGrad = LinearGradient(0f, 0f, 0f, height.toFloat(),
                    resources.getColor(android.R.color.holo_green_dark),
                    resources.getColor(android.R.color.holo_red_light),
                    Shader.TileMode.REPEAT)
            paint.shader = linGrad
        }

        var dataset = LineDataSet(entries, null)
        dataset.lineWidth = 5f
        dataset.circleRadius = 6f
        dataset.setCircleColor(Color.parseColor("#FFA1B4DC"))
        dataset.setCircleColorHole(Color.parseColor("#99f2c8"))
        dataset.color = Color.parseColor("#FFA184DC")
        dataset.setDrawCircleHole(true)
        dataset.setDrawCircles(true)
        dataset.setDrawHorizontalHighlightIndicator(false)
        dataset.setDrawHighlightIndicators(false)
        dataset.setDrawValues(false)
        dataset.mode = LineDataSet.Mode.HORIZONTAL_BEZIER
        dataset.cubicIntensity

        var lineData = LineData(dataset)
        chart.data = lineData

        var xAxis = chart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM_INSIDE
        xAxis.textColor = Color.WHITE
        xAxis.textSize = 14f
        xAxis.setDrawGridLines(true)
        xAxis.setDrawAxisLine(false)
        xAxis.yOffset = -10f
        //xAxis.enableGridDashedLine(8f, 24f, 0f)

        var yLAxis = chart.axisLeft
        yLAxis.isEnabled = false
        yLAxis.textColor = Color.BLACK

        var yRAxis = chart.axisRight
        yRAxis.setDrawLabels(false)
        yRAxis.setDrawAxisLine(false)
        yRAxis.setDrawGridLines(true)

        var marker = MyMarkerView(this, R.layout.test_layout)
        marker.chartView = chart
        chart.marker = marker

        chart.setVisibleXRangeMaximum(5f)
        chart.moveViewToX(10f)
        chart.isDoubleTapToZoomEnabled = true
        chart.setDrawGridBackground(false)
        chart.description.isEnabled = false
        chart.setScaleEnabled(false)
        chart.extraBottomOffset = -100f
        chart.legend.isEnabled =false
        //chart.animateY(2000, Easing.EasingOption.EaseInCubic)
        chart.invalidate()


    }
}
