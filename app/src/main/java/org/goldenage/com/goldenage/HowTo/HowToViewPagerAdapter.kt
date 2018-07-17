package org.tobap.com.togetherbap.HowTo

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter

class HowToViewPagerAdapter(fm: android.support.v4.app.FragmentManager): FragmentStatePagerAdapter(fm)
{
    var fragments = arrayOf(
            HowToImageFragment(),
            HowToImageFragment(),
            HowToImageFragment(),
            HowToLastFragment())

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }
}