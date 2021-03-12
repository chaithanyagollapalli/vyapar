package com.nero.vyapar.home_nav_bar.expense

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nero.vyapar.R

class ItemFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    companion object {

        fun newInstance() = ItemFragment()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

//        val adapter = ItemsAdapter()
//        itemsRecyclerView.layoutManager = LinearLayoutManager(context)
//        itemsRecyclerView.adapter = adapter

    }




}