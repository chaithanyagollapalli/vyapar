package com.nero.vyapar.repository

import androidx.lifecycle.LiveData
import com.nero.vyapar.constants.Constants
import com.nero.vyapar.local.dao.VyaparDAO
import com.nero.vyapar.local.entity.ExpenseEntity
import com.nero.vyapar.local.entity.ItemsEntity
import com.nero.vyapar.local.entity.PartyEntity
import com.nero.vyapar.local.entity.TransactionEntity

class ItemsRepository(private val databaseDao: VyaparDAO) {

    fun getAllItems(): LiveData<List<ItemsEntity>> {
        return databaseDao.getAllItems()
    }

    fun getAllTransactions(): LiveData<List<TransactionEntity>> {
        return databaseDao.getAllTransactions()
    }

    fun getAllParties(): LiveData<List<PartyEntity>> {
        return databaseDao.getAllParties()
    }

    fun getAllExpenses(): LiveData<List<ExpenseEntity>> {
        return databaseDao.getAllExpenses()
    }

    suspend fun addItem(itemsEntity: ItemsEntity) {
        databaseDao.insertItem(itemsEntity)
    }

    suspend fun addParty(partyEntity: PartyEntity) {
        databaseDao.insertParty(partyEntity)
    }

    suspend fun addExpense(expenseEntity: ExpenseEntity) {
        databaseDao.insertExpense(expenseEntity)
    }

    suspend fun addTransaction(transactionEntity: TransactionEntity) {

        databaseDao.insertTransaction(transactionEntity)
        val itemList = convertBilledItemNamesToList(transactionEntity.billedItemNames)
        val itemQuantity = convertBilledItemQuantityToList(transactionEntity.billedItemQuantity)

        updateItems(itemList, itemQuantity, transactionEntity.type)
        transactionEntity.partyName?.let {
            updateParty(
                it,
                transactionEntity.type!!,
                transactionEntity.total!!
            )
        }

    }

    suspend private fun updateParty(partyName: String, type: String, total: Long) {
        val party = databaseDao.getSpecificParty(partyName)
        if (type == Constants.PURCHASE) {
            if (party != null) {
                party.amout = party.amout?.minus(total)
            }
        } else {
            if (party != null) {
                party.amout = party.amout?.plus(total)
            }
        }
    }

    suspend fun updateItem(itemsEntity: ItemsEntity) {
        databaseDao.updateItems(itemsEntity)
    }

    private suspend fun updateItems(
        itemList: List<String>,
        itemQuantity: java.util.ArrayList<Int>,
        type: String?
    ) {

        for (i in itemList.indices) {

            val items = databaseDao.getSpecificItem(itemList[i])
            if (items != null) {
                if (type == Constants.PURCHASE) {
                    items.stock = items.stock?.plus(itemQuantity[i])
                } else {
                    items.stock = items.stock?.minus(itemQuantity[i])
                }
                databaseDao.updateItems(items);
            }

        }

    }

    private fun convertBilledItemNamesToList(billedItemNames: String?): List<String> {
        return billedItemNames!!.split(",")
    }

    private fun convertBilledItemQuantityToList(billedItemQuantity: String?): ArrayList<Int> {
        val data = billedItemQuantity!!.split(",")
        val list: ArrayList<Int> = ArrayList()
        for (item in data) {
            list.add(item.toInt())
        }
        return list;
    }


}