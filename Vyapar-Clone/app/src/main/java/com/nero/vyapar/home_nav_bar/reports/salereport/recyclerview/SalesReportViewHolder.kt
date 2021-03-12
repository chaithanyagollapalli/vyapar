package com.nero.vyapar.home_nav_bar.reports.salereport.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nero.vyapar.R

class SalesReportViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val mPartyName: TextView = view.findViewById(R.id.tvPartyName)
    val mId: TextView = view.findViewById(R.id.tvId)
    val mAmount: TextView = view.findViewById(R.id.tvAmount)
    val mBillNo: TextView = view.findViewById(R.id.tvBillNo)
    val mReceivedAmnt: TextView = view.findViewById(R.id.tvReceived)
    val mTotal: TextView = view.findViewById(R.id.tvTotal)
}