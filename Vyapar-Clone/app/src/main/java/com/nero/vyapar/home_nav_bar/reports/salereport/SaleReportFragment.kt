package com.nero.vyapar.home_nav_bar.reports.salereport

import android.app.Application
import android.content.Intent
import android.graphics.pdf.PdfDocument
import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.graphics.Paint
import androidx.core.app.ActivityCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.nero.vyapar.HomeActivity
import com.nero.vyapar.R
import com.nero.vyapar.home_nav_bar.party.PartiesViewModel
import com.nero.vyapar.home_nav_bar.reports.salereport.recyclerview.SalesReportAdapter
import com.nero.vyapar.local.entity.TransactionEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_sale_report.*
import kotlinx.android.synthetic.main.fragment_sale_report.*
import kotlinx.android.synthetic.main.fragment_sale_report.salesRecyclerView
import java.io.File
import java.io.FileOutputStream

@AndroidEntryPoint
class SaleReportFragment : Fragment() {

    var transactions = mutableListOf<TransactionEntity>()
    private val salesReportViewModel: SaleReportViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val adapter = SalesReportAdapter(transactions)
 //       salesRecyclerView.layoutManager = LinearLayoutManager()     //TODO - needs context
        salesRecyclerView.adapter = adapter

       /* salesReportViewModel.getSalesReport().observe(viewLifecycleOwner, Observer {
            transactions.clear()
            transactions.addAll(listOf(it))
            adapter.notifyDataSetChanged()
        })

        */
        return inflater.inflate(R.layout.fragment_sale_report, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        btnExportPdf.setOnClickListener {

        }
    }

}