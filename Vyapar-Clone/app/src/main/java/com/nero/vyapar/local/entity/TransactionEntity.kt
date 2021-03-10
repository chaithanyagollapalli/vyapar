package com.nero.vyapar.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactionsTable")
data class TransactionEntity(
    @ColumnInfo(name = "billNo") var billNo: Int?,
    @ColumnInfo(name = "type") var type: String?,
    @ColumnInfo(name = "partyName") var partyName: String?,
    @ColumnInfo(name = "billedItemNames") var billedItemNames: String?,
    @ColumnInfo(name = "billedItemQuantity") var billedItemQuantity: String?,
    @ColumnInfo(name = "paidAmt") var paidAmt: Long?,
    @ColumnInfo(name = "received") var received: Long? = 0,
    @ColumnInfo(name = "total") var total: Long?,
) {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}