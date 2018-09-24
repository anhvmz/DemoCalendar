package com.example.framgiavuminhanh.democalendar

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import java.text.SimpleDateFormat
import java.util.*


class CalendarItem : Fragment() {

    companion object {

        fun newInstance(text: String): CalendarItem {

            val f = CalendarItem()
            val b = Bundle()
            b.putString("msg", text)

            f.arguments = b

            return f
        }
    }

    @BindView(R.id.rv_day_by_month)
    lateinit var rvDayByMonth: RecyclerView

    var listDay: MutableList<String>? = null

    private var unbinder: Unbinder? = null
    private var date: Date? = null
    private var dateFormater = SimpleDateFormat("yyyy/MM/dd")
    private val numberOfMonth = intArrayOf(30, 28, 30, 40, 50)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        date = dateFormater.parse(arguments?.getString("msg"))


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View? = inflater.inflate(R.layout.calendar_item, container, false)
        if (view != null) {
            unbinder = ButterKnife.bind(this, view)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvDayByMonth.setHasFixedSize(true)
        rvDayByMonth.isHorizontalScrollBarEnabled = false
        rvDayByMonth.layoutManager = GridLayoutManager(context, 7) as RecyclerView.LayoutManager
        val dayByMonthAdapter = CalendarAdapter(context!!)
        listDay = mutableListOf()
        var num = 30
        if (arguments?.getString("msg") == "Month 2") {
            num = 20
        }
        for (i in 0..num) {
            listDay?.add(i.toString())
        }
        dayByMonthAdapter.setDay(listDay!!)
        rvDayByMonth.adapter = dayByMonthAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()

        // unbind the view to free some memory
        unbinder?.unbind()
    }
}
