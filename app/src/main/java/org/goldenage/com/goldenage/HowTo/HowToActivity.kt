package org.goldenage.com.goldenage.HowTo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_how_to.*
import org.goldenage.com.goldenage.R
import org.tobap.com.togetherbap.HowTo.HowToViewPagerAdapter

class HowToActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_how_to)

        setViewPager()
    }

    private fun setViewPager()
    {
        viewPager.adapter = HowToViewPagerAdapter(supportFragmentManager)
        indicator.setViewPager(viewPager)
    }

}
