package com.nero.vyapar.reports.sale

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.nero.vyapar.R
import com.nero.vyapar.local.dao.VyaparDAO
import com.nero.vyapar.local.database.VyaparDatabase
import com.nero.vyapar.local.entity.TransactionEntity
import kotlinx.android.synthetic.main.activity_sale_report.*

class SaleReportActivity : AppCompatActivity() {

    val transactions = mutableListOf<TransactionEntity>()
    lateinit var vyaparDatabase: VyaparDatabase
    lateinit var vyaparDAO: VyaparDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sale_report)

        vyaparDatabase = VyaparDatabase
        vyaparDAO = vyaparDatabase.getDAO()

        setRecyclerView()
        btnExportPdf.setOnClickListener {
            //fetch
            //store
        }

    }

    private fun setRecyclerView() {
        val adapter = SalesReportAdapter(transactions)
        salesRecyclerView.layoutManager = LinearLayoutManager(this)
        salesRecyclerView.adapter = adapter
    }
}