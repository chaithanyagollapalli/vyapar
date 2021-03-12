package com.nero.vyapar.home_nav_bar.reports

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nero.vyapar.constants.ReportConstant
import com.nero.vyapar.home_nav_bar.items.ItemsViewModel
import com.nero.vyapar.presentation.componenets.robotoFamily

class ReportsFragment : Fragment() {


    private val viewModel: ItemsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return ComposeView(requireContext()).apply {
            setContent {
                LazyColumn() {
                    itemsIndexed(
                        items = getListOfItems()
                    ) { index, item ->
                        if (item.type == ReportConstant.HEADING) {
                            ReportsTitleTextItem(name = item.Name)
                        } else {
                            ReportsTextItem(name = item.Name, onClick = {
                                OnItemClicked(it)
                            })
                        }
                    }
                }
            }
        }
    }

    private fun OnItemClicked(name: String) {
        if(name == "Sale Report"){
            val intent = Intent()
        }
    }


    fun getListOfItems(): ArrayList<ReportItem> {
        val list: ArrayList<ReportItem> = ArrayList()
        list.add(ReportItem("Transaction", ReportConstant.HEADING))
        list.add(ReportItem("Sale Report", ReportConstant.ITEM))
        list.add(ReportItem("Purchase Report", ReportConstant.ITEM))
        list.add(ReportItem("Daily Book", ReportConstant.ITEM))
        list.add(ReportItem("All Transactions", ReportConstant.ITEM))
        list.add(ReportItem("Profit & Loss", ReportConstant.ITEM))
        list.add(ReportItem("Cashflow", ReportConstant.ITEM))
        list.add(ReportItem("Balance Sheet", ReportConstant.ITEM))
        list.add(ReportItem("Party reports", ReportConstant.HEADING))
        list.add(ReportItem("Party Statement", ReportConstant.ITEM))
        list.add(ReportItem("All Party Report", ReportConstant.ITEM))
        list.add(ReportItem("Party Report by Items", ReportConstant.ITEM))
        list.add(ReportItem("Sale/Purchase by Party", ReportConstant.ITEM))
        list.add(ReportItem("GST reports", ReportConstant.HEADING))
        list.add(ReportItem("GSTR-1", ReportConstant.ITEM))
        list.add(ReportItem("GSTR-2", ReportConstant.ITEM))
        list.add(ReportItem("GSTR-3B", ReportConstant.ITEM))
        list.add(ReportItem("GST Detail Report", ReportConstant.ITEM))
        list.add(ReportItem("GSTR-9", ReportConstant.ITEM))
        list.add(ReportItem("Item/Stock reports", ReportConstant.HEADING))
        list.add(ReportItem("Stock Summary Report", ReportConstant.ITEM))
        list.add(ReportItem("Item Report by Party", ReportConstant.ITEM))
        list.add(ReportItem("Item Wise Profit & Loss", ReportConstant.ITEM))
        list.add(ReportItem("Low Stock Summary Report", ReportConstant.ITEM))
        list.add(ReportItem("Item Detail Report", ReportConstant.ITEM))
        list.add(ReportItem("Stock Detail Report", ReportConstant.ITEM))
        list.add(ReportItem("Stock summary By Item Category", ReportConstant.ITEM))
        list.add(ReportItem("Item Stock Tracking Report", ReportConstant.ITEM))
        list.add(ReportItem("Business status", ReportConstant.HEADING))
        list.add(ReportItem("Bank Statement", ReportConstant.ITEM))
        list.add(ReportItem("Discount Report", ReportConstant.ITEM))
        list.add(ReportItem("Tax Report", ReportConstant.ITEM))
        list.add(ReportItem("Tax Rate Report", ReportConstant.ITEM))
        list.add(ReportItem("Expense reports", ReportConstant.HEADING))
        list.add(ReportItem("Expense Transaction Report", ReportConstant.ITEM))
        list.add(ReportItem("Expense Category Report", ReportConstant.ITEM))
        list.add(ReportItem("Expense Item Report", ReportConstant.ITEM))
        list.add(ReportItem("Sale/Purchase Order reports", ReportConstant.HEADING))
        list.add(ReportItem("Sale/Purchase Order Transaction Report", ReportConstant.ITEM))
        list.add(ReportItem("Sale/Purchase Order Item Report", ReportConstant.ITEM))
        list.add(ReportItem("Loan Reports", ReportConstant.HEADING))
        list.add(ReportItem("Loan Statement", ReportConstant.ITEM))
        return list
    }

}

@Composable
fun ReportsTitleTextItem(name: String) {
    Text(
        text = name,
        color = Color(0xFF217089),
        modifier = Modifier
            .padding(start = 25.dp, top = 20.dp, bottom = 20.dp),
        fontFamily = robotoFamily,
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium
    )
}

@Composable
fun ReportsTextItem(name: String, onClick: (String) -> Unit) {

    Row(
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth()
            .clickable { onClick(name) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(40.dp))
        Text(
            text = name,
            color = Color(0xFF454E4C),
            fontFamily = robotoFamily,
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal
        )
    }


}
