package org.goldenage.com.goldenage

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.mikephil.charting.animation.Easing
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
    }

    fun graphSettting()
    {
        var entries = mutableListOf<Entry>()
        for (x in -10..10)
        {
            entries.add(Entry(x.toFloat(), x.toFloat()))
        }

        var dataset = LineDataSet(entries, null)
        dataset.lineWidth = 2f
        dataset.circleRadius = 6f
        dataset.setCircleColor(Color.parseColor("#FFA1B4DC"))
        dataset.setCircleColorHole(Color.BLUE)
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
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.textColor = Color.BLACK
        xAxis.setDrawGridLines(false)
        xAxis.enableGridDashedLine(8f, 24f, 0f)

        var yLAxis = chart.axisLeft
        yLAxis.setDrawGridLines(false)
        yLAxis.isEnabled = false
        yLAxis.textColor = Color.BLACK

        var yRAxis = chart.axisRight
        yRAxis.setDrawLabels(false)
        yRAxis.setDrawAxisLine(false)
        yRAxis.setDrawGridLines(false)

        var marker = MyMarkerView(this, R.layout.test_layout)
        marker.chartView = chart
        chart.marker = marker

        chart.setVisibleXRangeMaximum(5f)
        chart.moveViewToX(10f)
        chart.isDoubleTapToZoomEnabled = true
        chart.setDrawGridBackground(false)
        chart.description.isEnabled = false
        chart.setScaleEnabled(false)
        chart.legend.isEnabled =false
        chart.animateY(2000, Easing.EasingOption.EaseInCubic)
        chart.invalidate()
    }
}
