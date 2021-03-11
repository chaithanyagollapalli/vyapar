package com.nero.vyapar.home_nav_bar.menuItems.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nero.vyapar.R
import com.nero.vyapar.home_nav_bar.menuItems.viewHolders.ServicesViewHolder

class ServicesAdapter : RecyclerView.Adapter<ServicesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_items_units_layout,parent,false)
        return ServicesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServicesViewHolder, position: Int) {
        holder.setData()
    }

    override fun getItemCount(): Int {
        return 1
    }
}