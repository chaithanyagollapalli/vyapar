package com.nero.vyapar.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.nero.vyapar.local.entity.ItemsEntity
import com.nero.vyapar.local.entity.PartyEntity
import com.nero.vyapar.local.entity.TransactionEntity

@Dao
interface VyaparDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(itemsEntity: ItemsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertParty(partyEntity: PartyEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTransaction(transactionEntity: TransactionEntity)

}