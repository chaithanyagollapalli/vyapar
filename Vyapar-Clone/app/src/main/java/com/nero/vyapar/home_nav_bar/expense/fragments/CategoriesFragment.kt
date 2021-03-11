package com.nero.vyapar.home_nav_bar.expense.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.nero.vyapar.R
import com.nero.vyapar.home_nav_bar.expense.ExpensesViewModel
import com.nero.vyapar.home_nav_bar.expense.adapters.CategoriesAdapter
import com.nero.vyapar.home_nav_bar.expense.adapters.ItemsAdapter
import com.nero.vyapar.local.entity.ExpenseEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_categories.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CategoriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

@AndroidEntryPoint
class CategoriesFragment : Fragment() {

    val viewModel: ExpensesViewModel by viewModels()
    private val expenseList = mutableListOf<ExpenseEntity>()

    val adapter = CategoriesAdapter(expenseList)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    companion object {
        fun newInstance() = CategoriesFragment()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getExpenses().observe(this, Observer {
            expenseList.clear()
            expenseList.addAll(it)
            adapter.notifyDataSetChanged()
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        categoriesRecyclerView.layoutManager = LinearLayoutManager(context)
        categoriesRecyclerView.adapter = adapter

    }
}


