package com.nero.vyapar.home_nav_bar.reports.salereport

import android.content.Context
import android.os.Bundle
import android.print.PrintAttributes
import android.print.PrintManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.itextpdf.text.*
import com.itextpdf.text.pdf.PdfWriter
import com.nero.vyapar.R
import com.nero.vyapar.home_nav_bar.reports.salereport.recyclerview.SalesReportAdapter
import com.nero.vyapar.local.entity.TransactionEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_sale_report.*
import kotlinx.android.synthetic.main.fragment_sale_report.*
import kotlinx.android.synthetic.main.fragment_sale_report.salesRecyclerView

import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import java.io.File
import java.io.FileOutputStream


@AndroidEntryPoint
class SaleReportFragment : Fragment() {

    var file_name: String = "test_pdf.pdf"

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
            Dexter.withActivity(activity)
                .withPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(object : PermissionListener {
                    override fun onPermissionGranted(response: PermissionGrantedResponse?) {
                        savePdf(Common.getAppPath(this@SaleReportFragment) + file_name)
                    }

                    override fun onPermissionDenied(response: PermissionDeniedResponse?) {
                        TODO("Not yet implemented")
                    }

                    override fun onPermissionRationaleShouldBeShown(
                        permission: PermissionRequest?,
                        token: PermissionToken?
                    ) {
                        TODO("Not yet implemented")
                    }

                })
        }

    }


    private fun savePdf(appPath: String) {
        if (File(appPath).exists())
            File(appPath).delete()
        try {
            val document = Document()

            PdfWriter.getInstance(document, FileOutputStream(appPath))

            document.open()
            document.pageSize = PageSize.A4
            document.addCreationDate()
            document.addAuthor("Billed")
            document.addCreator("Vyapar")

            addNewItem(document, "Sales Report", Element.ALIGN_CENTER)

            document.close()

            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()

            printPdf()

        } catch (e: Exception) {

        }
    }

    private fun printPdf() {
        val printManager = context?.getSystemService(Context.PRINT_SERVICE) as PrintManager
        try {
            val printAdapter = PdfDocumentAdapter(
                requireActivity().applicationContext,
                Common.getAppPath(this) + file_name
            )
            printManager.print("Document", printAdapter, PrintAttributes.Builder().build())
        } catch (e: Exception) {

        }
    }

    @Throws(DocumentException::class)
    private fun addNewItem(document: Document, text: String, align: Int) {
        val chunk = Chunk(text)
        val p = Paragraph(chunk)
        p.alignment = align
        document.add(p)
    }

}