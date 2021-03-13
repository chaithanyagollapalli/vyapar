package com.nero.vyapar.home_nav_bar.reports.salereport

import android.content.Intent.ACTION_OPEN_DOCUMENT_TREE
import android.os.Environment
import androidx.documentfile.provider.DocumentFile
import com.nero.vyapar.R
import com.nero.vyapar.home_nav_bar.reports.salereport.SaleReportFragment
import java.io.File

object Common {
    fun getAppPath(context: SaleReportFragment):String{
        val dir = File(Environment.DIRECTORY_DOCUMENTS + File.separator
        + context.resources.getString(R.string.app_name)
        + File.separator)

        if (!dir.exists())
            dir.mkdir()
        return dir.path+File.separator
    }
}