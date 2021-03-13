package com.nero.vyapar.home_nav_bar.menuItems.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nero.vyapar.R
import com.nero.vyapar.home_nav_bar.menuItems.onClick.OnItemClick
import com.nero.vyapar.home_nav_bar.menuItems.viewHolders.ProductsViewHolder
import com.nero.vyapar.local.entity.ItemsEntity

class ProductsAdapter(
    private val productList: List<ItemsEntity>,
    private val listener: OnItemClick
) :
    RecyclerView.Adapter<ProductsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.stock_item_list_layout, parent, false)
        return ProductsViewHolder(view,listener)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val product = productList[position]
        holder.setData(product)
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}