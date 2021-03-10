package com.nero.vyapar.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nero.vyapar.local.entity.ItemsEntity
import com.nero.vyapar.local.entity.PartyEntity
import com.nero.vyapar.local.entity.TransactionEntity

@Dao
interface VyaparDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(itemsEntity: ItemsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertParty(partyEntity: PartyEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transactionEntity: TransactionEntity)


    @Query("SELECT * FROM ItemsTable")
    fun getAllItems(): LiveData<List<ItemsEntity>>

}