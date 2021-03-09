package com.nero.vyapar.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nero.vyapar.local.dao.VyaparDAO
import com.nero.vyapar.local.entity.ItemsEntity
import com.nero.vyapar.local.entity.PartyEntity
import com.nero.vyapar.local.entity.TransactionEntity

@Database(
    entities = [ItemsEntity::class, PartyEntity::class, TransactionEntity::class],
    version = 1
)
abstract class VyaparDatabase : RoomDatabase() {
    abstract fun getDAO(): VyaparDAO
}