package com.nero.vyapar.home_nav_bar.reports.salereport.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nero.vyapar.R
import com.nero.vyapar.local.entity.TransactionEntity

class SalesReportAdapter(private val transactions: List<TransactionEntity>): RecyclerView.Adapter<SalesReportViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SalesReportViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sales_report,parent,false)
        return SalesReportViewHolder(view)
    }

    override fun onBindViewHolder(holder: SalesReportViewHolder, position: Int) {
        holder.mPartyName.text = transactions[position].partyName.toString()
        holder.mId.text = transactions[position].id.toString()
        holder.mAmount.text = transactions[position].paidAmt.toString()
        holder.mBillNo.text = transactions[position].billNo.toString()
        holder.mReceivedAmnt.text = transactions[position].received.toString()
        holder.mTotal.text = transactions[position].total.toString()
    }

    override fun getItemCount(): Int {
        return transactions.size
    }
}