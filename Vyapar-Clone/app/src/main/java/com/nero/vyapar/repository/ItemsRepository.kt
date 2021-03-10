package com.nero.vyapar.repository

import androidx.lifecycle.LiveData
import com.nero.vyapar.local.dao.VyaparDAO
import com.nero.vyapar.local.entity.ItemsEntity

class ItemsRepository(private val databaseDao: VyaparDAO) {

    fun getAllItems(): LiveData<List<ItemsEntity>> {
        return databaseDao.getAllItems()
    }

    suspend fun addItem(itemsEntity: ItemsEntity) {
        databaseDao.insertItem(itemsEntity)
    }

}