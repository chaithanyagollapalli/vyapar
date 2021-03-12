package com.nero.vyapar.home_nav_bar.purchase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.nero.vyapar.R
import com.nero.vyapar.constants.Constants
import com.nero.vyapar.home_nav_bar.sale.BilledItem
import com.nero.vyapar.local.entity.TransactionEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.purchase_fragment.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PurchaseFragment : Fragment() {

    companion object {
        fun newInstance() = PurchaseFragment()
    }

    private val sharedViewModel: PurchaseSharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.purchase_fragment, container, false)

        view.findViewById<ComposeView>(R.id.ItemRecyclerCompose).setContent {
            LazyColumn() {
                itemsIndexed(
                    items = sharedViewModel.listOfPurchase.value
                ) { index, purchase ->
                    BilledItem(purchase.productName, index, purchase.quantity, purchase.price)
                }
            }
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnAddItems.setOnClickListener {
            val action = PurchaseFragmentDirections.actionNavPurchaseToAddPurchaseFragment()
            findNavController().navigate(action)
        }

        btnSave.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                sharedViewModel.addTransaction(
                    TransactionEntity(
                        etBillNo.text.toString().toInt(),
                        Constants.PURCHASE,
                        etParty.text.toString(),
                        convertListToBilledItems(),
                        convertListToBilledQuantity(),
                        etPaid.text.toString().toLong(),
                        balanceDue.text.toString().toLong(),
                        etTotal.text.toString().toLong()
                    )
                )
                sharedViewModel.listOfPurchase.value.clear()

            }

            activity?.onBackPressed()

        }


    }

    private fun convertListToBilledQuantity(): String? {
        val data = sharedViewModel.listOfPurchase.value
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
        val data = sharedViewModel.listOfPurchase.value
        var purchase = ""
        for (i in data.indices) {
            if (i == 0) {
                purchase += "${data[i].productName}"
            } else {
                purchase += ",${data[i].productName}"
            }

        }
        return purchase
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}