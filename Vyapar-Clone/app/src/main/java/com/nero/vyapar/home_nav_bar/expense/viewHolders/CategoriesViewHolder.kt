package com.nero.vyapar.home_nav_bar.expense.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.nero.vyapar.local.entity.ExpenseEntity
import kotlinx.android.synthetic.main.item_category_layout.view.*

class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setData(expenseEntity: ExpenseEntity) {
        itemView.apply {
            categoryName.text = expenseEntity.cetegory.toString()
            categoryAmt.text = expenseEntity.totalAmount.toString()
        }
    }
}