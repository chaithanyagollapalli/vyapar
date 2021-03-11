package com.nero.vyapar.home_nav_bar.purchase

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.nero.vyapar.R
import com.nero.vyapar.home_nav_bar.sale.SaleSharedViewModel
import dagger.hilt.android.AndroidEntryPoint

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
        return inflater.inflate(R.layout.purchase_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


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

}