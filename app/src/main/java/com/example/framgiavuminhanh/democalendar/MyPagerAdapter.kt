package com.example.framgiavuminhanh.democalendar

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import xyz.santeri.wvp.WrappingFragmentPagerAdapter

class MyPagerAdapter(fm: FragmentManager, private val fragments: MutableList<Fragment>) : WrappingFragmentPagerAdapter(fm) {

    override fun getItem(pos: Int): Fragment {
        return fragments[pos]
    }

    override fun getCount(): Int {
        return fragments.size
    }
}