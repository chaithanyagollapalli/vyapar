package com.nero.vyapar.home_nav_bar.menuItems

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nero.vyapar.R
import com.nero.vyapar.home_nav_bar.menuItems.adapters.UnitsAdapter
import kotlinx.android.synthetic.main.fragment_units.*

class UnitsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_units, container, false)
    }

    companion object {
        fun newInstance() = UnitsFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        val unitsAdapter = UnitsAdapter()
//        unitsRecyclerView.adapter = unitsAdapter
//        unitsRecyclerView.layoutManager = LinearLayoutManager(context)
    }

}