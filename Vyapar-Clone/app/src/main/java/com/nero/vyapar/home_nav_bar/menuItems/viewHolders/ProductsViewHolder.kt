package com.nero.vyapar.home_nav_bar.menuItems.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.nero.vyapar.home_nav_bar.menuItems.onClick.OnItemClick
import com.nero.vyapar.local.entity.ItemsEntity
import kotlinx.android.synthetic.main.menu_items_services_layout.view.*
import kotlinx.android.synthetic.main.purchase_fragment.view.*
import kotlinx.android.synthetic.main.stock_item_list_layout.view.*

class ProductsViewHolder(itemView: View, val listener: OnItemClick) :
    RecyclerView.ViewHolder(itemView) {
    fun setData(itemsEntity: ItemsEntity) {
        itemView.apply {
            tvMenuItemName.text = itemsEntity.name
//            tvStockValueNumber.text = itemsEntity.itemCode
            tvSalePriceNumber.text = itemsEntity.salePrice.toString()
            tvPurchasePriceNumber.text = itemsEntity.purchasePrice.toString()
            tvStockQuantityNumber.text = itemsEntity.stock.toString()

            ibShareItem.setOnClickListener {

                listener.onClickShare(itemsEntity)
            }

            ibEDitItem.setOnClickListener {
                listener.onEditClick(itemsEntity)
            }
        }
    }
}