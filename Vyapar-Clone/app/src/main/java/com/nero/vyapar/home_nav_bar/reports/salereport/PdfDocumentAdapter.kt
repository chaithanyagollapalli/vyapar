package com.nero.vyapar.home_nav_bar.reports.salereport

import android.content.Context
import android.os.Bundle
import android.os.CancellationSignal
import android.os.ParcelFileDescriptor
import android.print.PageRange
import android.print.PrintAttributes
import android.print.PrintDocumentAdapter
import android.print.PrintDocumentInfo
import android.util.Log
import java.io.*

class PdfDocumentAdapter(context: Context,path : String): PrintDocumentAdapter() {

    internal var context: Context?=null
    internal var path: String = ""

    init {
        this.context = context
        this.path = path
    }

    override fun onLayout(
        oldAttributes: PrintAttributes?,
        newAttributes: PrintAttributes?,
        cancellationSignal: CancellationSignal?,
        callback: LayoutResultCallback?,
        extras: Bundle?
    ) {
        if (cancellationSignal!!.isCanceled)
            callback!!.onLayoutCancelled()
        else{
            var builder = PrintDocumentInfo.Builder("file name")
            builder.setContentType(PrintDocumentInfo.CONTENT_TYPE_DOCUMENT)
                .setPageCount(PrintDocumentInfo.PAGE_COUNT_UNKNOWN).build()
            callback!!.onLayoutFinished(builder.build(),newAttributes != oldAttributes)
        }
    }

    override fun onWrite(
        pages: Array<out PageRange>?,
        destination: ParcelFileDescriptor?,
        cancellationSignal: CancellationSignal?,
        callback: WriteResultCallback?
    ) {
        var input :InputStream?=null
        var out: OutputStream?=null
        try{
            val file = File(path)
            input = FileInputStream(file)
            out = FileOutputStream(destination!!.fileDescriptor)

            if (!cancellationSignal!!.isCanceled) {
                input.copyTo(out)
                callback!!.onWriteFinished(arrayOf(PageRange.ALL_PAGES))
            }
            else
                callback!!.onWriteCancelled()
        }catch (e:Exception){
            callback!!.onWriteFailed(e.message)
            Log.e("Sumeet",""+e.message)
        }
        finally {
            try {
                input!!.close()
                out!!.close()
            }catch (e: Exception){
                Log.e("Sumeet",""+e.message)
            }
        }
    }
}