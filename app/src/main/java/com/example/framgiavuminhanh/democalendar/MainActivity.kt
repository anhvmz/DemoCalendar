package com.example.framgiavuminhanh.democalendar

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import butterknife.BindView
import butterknife.ButterKnife

class MainActivity : AppCompatActivity() {

    @BindView(R.id.viewPager)
    lateinit var pager : VerticalViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        val fragments = mutableListOf<Fragment>()
        fragments.add(CalendarItem.newInstance("Month 1"))
        fragments.add(CalendarItem.newInstance("Month 2"))
        fragments.add(CalendarItem.newInstance("Month 3"))
        Log.d("ANHVM", fragments.size.toString())
        pager.adapter = MyPagerAdapter(supportFragmentManager, fragments)

    }
}