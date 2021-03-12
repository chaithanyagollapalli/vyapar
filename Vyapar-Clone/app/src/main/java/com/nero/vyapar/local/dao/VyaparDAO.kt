package com.nero.vyapar.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
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

    @Query("SELECT * FROM transactionsTable")
    fun getAllTransactions(): LiveData<List<TransactionEntity>>

    @Query("SELECT * FROM partyTable")
    fun getAllParties(): LiveData<List<PartyEntity>>

    @Query("SELECT * FROM ItemsTable WHERE itemName= :itemName")
    suspend fun getSpecificItem(itemName: String): ItemsEntity?

    @Query("SELECT * FROM partyTable WHERE partyName= :partyName")
    suspend fun getSpecificParty(partyName: String): PartyEntity?

    @Update
    suspend fun updateItems(itemsEntity: ItemsEntity)

    @Update
    suspend fun updateParty(partyEntity: PartyEntity)
}