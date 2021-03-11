package com.nero.vyapar.home_nav_bar.menuItems.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nero.vyapar.R
import com.nero.vyapar.home_nav_bar.menuItems.viewHolders.ProductsViewHolder

class ProductsAdapter:RecyclerView.Adapter<ProductsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.stock_item_list_layout,parent,false)
        return ProductsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.setData()
    }

    override fun getItemCount(): Int {
        return 1
    }
}