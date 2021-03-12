package com.nero.vyapar.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
@Entity(tableName = "ItemsTable")
data class ItemsEntity(
    @ColumnInfo(name = "itemName") var name: String?,
    @ColumnInfo(name = "type") var type: String?,
    @ColumnInfo(name = "itemCode") var itemCode: String?,
    @ColumnInfo(name = "sacCode") var sacCode: String?,
    @ColumnInfo(name = "salePrice") var salePrice: Long?,
    @ColumnInfo(name = "purchasePrice") var purchasePrice: Long?,
    @ColumnInfo(name = "taxRate") var taxRate: Float?,
    @ColumnInfo(name = "stock") var stock: Long?,
) : Parcelable {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}