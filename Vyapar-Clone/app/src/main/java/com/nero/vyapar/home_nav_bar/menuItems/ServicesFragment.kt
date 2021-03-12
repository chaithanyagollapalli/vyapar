package com.nero.vyapar.home_nav_bar.menuItems

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.nero.vyapar.R
import com.nero.vyapar.home_nav_bar.menuItems.adapters.ServicesAdapter
import com.nero.vyapar.home_nav_bar.menuItems.adapters.UnitsAdapter
import kotlinx.android.synthetic.main.fragment_services.*
import kotlinx.android.synthetic.main.fragment_units.*
import kotlinx.android.synthetic.main.menu_items_fragment.*

class ServicesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_services, container, false)
    }

    companion object {
        fun newInstance() = ServicesFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        val servicesAdapter = ServicesAdapter()
//        servicesRecyclerView.adapter = servicesAdapter
//        servicesRecyclerView.layoutManager = LinearLayoutManager(context)
    }


}