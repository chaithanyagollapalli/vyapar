package com.nero.vyapar.home_nav_bar.sale

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.nero.vyapar.R
import com.nero.vyapar.constants.Constants
import com.nero.vyapar.local.entity.TransactionEntity
import com.nero.vyapar.presentation.componenets.robotoFamily
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.sale_fragment.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SaleFragment : Fragment() {


    private val sharedViewModel: SaleSharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.sale_fragment, container, false)
        view.findViewById<ComposeView>(R.id.ItemRecyclerCompose).setContent {
            LazyColumn() {
                itemsIndexed(
                    items = sharedViewModel.listOfSale.value
                ) { index, sale ->
                    BilledItem(sale.productName, index, sale.quantity, sale.price)
                }
            }
        }



        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btnAddItems2.setOnClickListener {
            val action = SaleFragmentDirections.actionNavSaleToAddSaleFragment()
            findNavController().navigate(action)
        }

        btnSave2.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                sharedViewModel.addTransaction(
                    TransactionEntity(
                        etInvNo.text.toString().toInt(),
                        Constants.SALE,
                        etCustomer.text.toString(),
                        convertListToBilledItems(),
                        convertListToBilledQuantity(),
                        etPaidAmount.text.toString().toLong(),
                        etPaidAmount.text.toString().toLong(),
                        etTotalAmount.text.toString().toLong()
                    )
                )
            }
        }
    }

    private fun convertListToBilledQuantity(): String? {
        val data = sharedViewModel.listOfSale.value
        var quantity = ""
        for (i in data.indices) {

            if (i == 0) {
                quantity += "${data[i].quantity}"
            } else {
                quantity += ",${data[i].quantity}"
            }

        }
        return quantity
    }

    private fun convertListToBilledItems(): String? {
        val data = sharedViewModel.listOfSale.value
        var sales = ""
        for (i in data.indices) {
            if (i == 0) {
                sales += "${data[i].productName}"
            } else {
                sales += ",${data[i].productName}"
            }

        }
        return sales
    }
}

@Composable
fun BilledItem(name: String, index: Int, quantity: Int, price: Long) {
    Card(
        modifier = Modifier
            .height(70.dp)
            .fillMaxWidth(),
        backgroundColor = Color(0xFFF2F2F2)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceBetween,

            ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "${index + 1}. $name",
                    color = Color(0xFF2A424A),
                    fontWeight = FontWeight.Medium,
                    fontFamily = robotoFamily,
                    fontSize = 15.sp
                )

                Text(
                    text = "${quantity * price}",
                    color = Color(0xFF236885),
                    fontWeight = FontWeight.Medium,
                    fontFamily = robotoFamily,
                    fontSize = 15.sp
                )

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "item Subtotal",
                    color = Color(0xFF2A424A),
                    fontWeight = FontWeight.Medium,
                    fontFamily = robotoFamily,
                    fontSize = 10.sp
                )

                Text(
                    text = "$quantity X $price = ${quantity * price}",
                    color = Color.LightGray,
                    fontWeight = FontWeight.Normal,
                    fontFamily = robotoFamily,
                    fontSize = 15.sp
                )

            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun salePreview() {
    Column {
        BilledItem("cola", 1, 10, 50)
    }
}