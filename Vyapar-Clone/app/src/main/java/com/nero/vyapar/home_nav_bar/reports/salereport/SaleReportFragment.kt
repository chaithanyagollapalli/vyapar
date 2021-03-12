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
import com.nero.vyapar.home_nav_bar.expense.fragments.ItemFragment
import com.nero.vyapar.home_nav_bar.party.PartiesViewModel
import com.nero.vyapar.home_nav_bar.reports.salereport.recyclerview.SalesReportAdapter
import com.nero.vyapar.local.entity.TransactionEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_sale_report.*
import kotlinx.android.synthetic.main.fragment_sale_report.*
import kotlinx.android.synthetic.main.fragment_sale_report.salesRecyclerView
import java.io.File
import java.io.FileOutputStream
import android.graphics.pdf.PdfDocument.PageInfo
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.ui.text.intl.Locale
import androidx.core.content.ContextCompat.checkSelfPermission
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter
import com.itextpdf.text.pdf.fonts.otf.TableHeader
import org.w3c.dom.Document
import java.lang.Exception
import java.util.jar.Manifest


@AndroidEntryPoint
class SaleReportFragment : Fragment() {

    var transactions = mutableListOf<TransactionEntity>()
    private val salesReportViewModel: SaleReportViewModel by viewModels()
    val adapter = SalesReportAdapter(transactions)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sale_report, container, false)
    }

    companion object {

        fun newInstance() = SaleReportFragment()

    }

    override fun onResume() {
        super.onResume()
        salesReportViewModel.getReport().observe(this, Observer {
            transactions.clear()
            transactions.addAll(it)
            adapter.notifyDataSetChanged()
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        salesRecyclerView.layoutManager = LinearLayoutManager(context)
        salesRecyclerView.adapter = adapter

        ibExportPdf.setOnClickListener {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
                savePdf()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun savePdf() {
        val mDoc = com.itextpdf.text.Document()
        val mFileName = SimpleDateFormat("yyyyMMdd_HHmmss").format(System.currentTimeMillis())
        val mFilePath = Environment.getExternalStorageDirectory().toString() + "/" + mFileName + ".pdf"
        try{
            PdfWriter.getInstance(mDoc, FileOutputStream(mFilePath))
            mDoc.open()
            val data = "this data will enter"
            mDoc.addAuthor("Vyapar_Clone")
            val table = PdfPTable(transactions.size)
            for (i in 0..transactions.size){
                val para = Paragraph(transactions[i].toString())
                val cell = PdfPCell(para)
                table.addCell(cell)
            }
            mDoc.add(table)
            mDoc.close()

        }catch (e: Exception){}
    }

}