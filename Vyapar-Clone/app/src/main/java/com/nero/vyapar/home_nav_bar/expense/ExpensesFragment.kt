package com.nero.vyapar.home_nav_bar.expense

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.nero.vyapar.R
import com.nero.vyapar.home_nav_bar.expense.fragments.CategoriesFragment
import com.nero.vyapar.home_nav_bar.expense.fragments.ItemFragment

import kotlinx.android.synthetic.main.expenses_fragment.*


class ExpensesFragment : Fragment() {

    companion object {
        fun newInstance() = ExpensesFragment()
    }

    private lateinit var viewModel: ExpensesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.expenses_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewPagerAdapter = ExpenseViewPagerAdapter(this)

        expenseViewPager.adapter = viewPagerAdapter

        TabLayoutMediator(expenseTabLayout, expenseViewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Categories"
                1 -> "Items"
                else -> "Categories"
            }

        }.attach()



        addExpensesBtn.setOnClickListener {
            val action = ExpensesFragmentDirections.actionNavExpensesToAddExpenseFragment()
            findNavController().navigate(action)
        }
    }

    private class ExpenseViewPagerAdapter(fm: ExpensesFragment) :
        FragmentStateAdapter(fm) {

        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> return CategoriesFragment.newInstance()
                1 -> return ItemFragment.newInstance()
                else -> CategoriesFragment.newInstance()
            }
        }
    }


}