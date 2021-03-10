package com.nero.vyapar.home_nav_bar.items

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nero.vyapar.R
import com.nero.vyapar.databinding.FragmentItemBinding
import com.nero.vyapar.home_nav_bar.expense.ExpensesFragment
import com.nero.vyapar.home_nav_bar.expense.ExpensesViewModel

class ItemsFragment : Fragment() {

    companion object {
        fun newInstance() = ItemsFragment()
    }

    private lateinit var viewModel: ItemsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ItemsViewModel::class.java)
        // TODO: Use the ViewModel
    }
}