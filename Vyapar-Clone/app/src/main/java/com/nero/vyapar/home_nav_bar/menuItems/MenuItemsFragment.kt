package com.nero.vyapar.home_nav_bar.menuItems

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.nero.vyapar.R
import com.nero.vyapar.home_nav_bar.expense.CategoriesFragment
import kotlinx.android.synthetic.main.menu_items_fragment.*

class MenuItemsFragment : Fragment() {

    companion object {
        fun newInstance() = MenuItemsFragment()
    }

    private lateinit var viewModel: MenuItemsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.menu_items_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MenuItemsViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewPagerAdapter = MenuItemsViewPagerAdapter(this)

        menuItemsViewPager.adapter = viewPagerAdapter

        TabLayoutMediator(menuItemsTabLayout, menuItemsViewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Products"
                1 -> "Services"
                2 -> "Units"
                else -> "Products"
            }

        }.attach()
    }

    private class MenuItemsViewPagerAdapter(fm: MenuItemsFragment) :
        FragmentStateAdapter(fm) {

        override fun getItemCount(): Int {
            return 3
        }

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> return ProductFragment.newInstance()
                1 -> return ServicesFragment.newInstance()
                2 -> return UnitsFragment.newInstance()
                else -> ProductFragment.newInstance()
            }
        }
    }


}