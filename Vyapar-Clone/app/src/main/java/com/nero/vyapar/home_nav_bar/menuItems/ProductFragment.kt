package com.nero.vyapar.home_nav_bar.menuItems

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nero.vyapar.R
import com.nero.vyapar.home_nav_bar.menuItems.adapters.ProductsAdapter
import com.nero.vyapar.home_nav_bar.menuItems.adapters.ServicesAdapter
import kotlinx.android.synthetic.main.fragment_services.*

class ProductFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    companion object {
        fun newInstance() = ProductFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        val productsAdapter = ProductsAdapter()
//        servicesRecyclerView.adapter = productsAdapter
//        servicesRecyclerView.layoutManager = LinearLayoutManager(context)
    }



}