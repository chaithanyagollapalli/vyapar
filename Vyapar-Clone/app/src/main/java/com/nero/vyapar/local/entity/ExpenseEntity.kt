package com.nero.vyapar.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expenseTable")
data class ExpenseEntity(
    @ColumnInfo(name = "Category") var cetegory: String,
    @ColumnInfo(name = "Item Name") var itemName: String,
    @ColumnInfo(name = "Quantity") var quantity: Int,
    @ColumnInfo(name = "Price") var price: Int,
    @ColumnInfo(name = "Total Amount") var totalAmount: Int,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}