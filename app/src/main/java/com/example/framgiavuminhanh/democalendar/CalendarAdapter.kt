package com.example.framgiavuminhanh.democalendar

import android.content.Context
import android.graphics.Point
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife

class CalendarAdapter(private val context: Context) : RecyclerView.Adapter<CalendarAdapter.DayByMonthViewHolder>() {

    private var dayByMonths = mutableListOf<String>()

    init {
        calculateCellWidth()
    }

    private fun calculateCellWidth() {
        val display = (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
        val size = Point()
        display.getSize(size)
        widthCell = (size.x -16) / 7
    }

    private var widthCell: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayByMonthViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.day_item, parent, false)
        view.minimumWidth = widthCell
        return DayByMonthViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dayByMonths.size
    }

    override fun onBindViewHolder(holder: DayByMonthViewHolder, position: Int) {
        holder.tvDay.text = dayByMonths[position]
    }

    fun setDay(dayByMonths: MutableList<String>) {
        this.dayByMonths = dayByMonths
        notifyDataSetChanged()
    }

    inner class DayByMonthViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {
        @BindView(R.id.tv_day)
        lateinit var tvDay: TextView
        init {
            ButterKnife.bind(this, rootView)
        }
    }
}