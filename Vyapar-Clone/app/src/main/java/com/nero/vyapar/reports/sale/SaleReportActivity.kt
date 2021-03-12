package com.nero.vyapar.reports.sale

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nero.vyapar.R
import com.nero.vyapar.home_nav_bar.reports.salereport.recyclerview.SalesReportAdapter
import com.nero.vyapar.local.entity.TransactionEntity
import com.nero.vyapar.viewmodel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_sale_report.*

@AndroidEntryPoint
class SaleReportActivity : AppCompatActivity() {

    val transactions = mutableListOf<TransactionEntity>()
    val viewModelObject: viewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sale_report)
        setRecyclerView()
        btnExportPdf.setOnClickListener {
            viewModelObject
        }

    }

    private fun setRecyclerView() {
        val adapter = SalesReportAdapter(transactions)
        salesRecyclerView.layoutManager = LinearLayoutManager(this)
        salesRecyclerView.adapter = adapter
    }
}