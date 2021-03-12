package com.nero.vyapar.home_nav_bar.items

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nero.vyapar.constants.Constants
import com.nero.vyapar.local.entity.ItemsEntity
import com.nero.vyapar.local.entity.PartyEntity
import com.nero.vyapar.local.entity.TransactionEntity
import com.nero.vyapar.repository.ItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(
    private val repository: ItemsRepository
) : ViewModel() {

    init {
        getAllItems()
        getAllTransactions()
        getAllParties()
//         addItem(ItemsEntity("cola", "sale", "33", "as", 332, 231, 0.6f, 30))
//         addItem(ItemsEntity("car", "sale", "33", "as", 332, 231, 0.6f, 30))
//         addItem(ItemsEntity("book", "sale", "33", "as", 332, 231, 0.6f, 30))
//
//        addParty(PartyEntity("batman", "454", "343", 100))
//        addTransaction(
//             TransactionEntity(
//                 54,
//                 Constants.PURCHASE,
//                 "batman",
//                 "cola,car",
//                 "10,15",
//                 1000,
//                 500,
//                 1000
//             )
//         )
    }

    val selectedType: MutableState<Int> = mutableStateOf(0)

    var items: MutableState<List<ItemsEntity>> = mutableStateOf(listOf())
    var transcations: MutableState<List<TransactionEntity>> = mutableStateOf(listOf())
    var parties: MutableState<List<PartyEntity>> = mutableStateOf(listOf())
    var totalToGet: MutableState<Long> = mutableStateOf(0)
    var totalSale: MutableState<Long> = mutableStateOf(0)
    var totalPurchase: MutableState<Long> = mutableStateOf(0)
    var totalToGive: MutableState<Long> = mutableStateOf(0)
    var totalExpenses: MutableState<Long> = mutableStateOf(0)

    fun getAllItems() {
        repository.getAllItems().observeForever() {
            items.value = it
        }
    }

    fun getAllTransactions() {
        repository.getAllTransactions().observeForever() {
            transcations.value = it
            var sale: Long = 0;
            var pruchase: Long = 0;
            var toget: Long = 0;
            var togive: Long = 0;
            
            for (transaction in it) {
                if (transaction.total != null && transaction.type != Constants.PURCHASE) {
                    sale += transaction.total!!
                    toget += transaction.total!! - transaction.received!!
                } else if (transaction.total != null) {
                    pruchase += transaction.total!!
                    togive += (transaction.total!! - transaction.paidAmt!!)
                }
            }

            totalToGive.value = togive
            totalToGet.value = toget
            totalSale.value = sale
            totalPurchase.value = pruchase
        }
    }

    fun getAllParties() {
        repository.getAllParties().observeForever() {
            parties.value = it
        }

    }

    fun addTransaction(transactionEntity: TransactionEntity) {
        viewModelScope.launch() {
            repository.addTransaction(transactionEntity)
        }
    }

    fun addItem(itemsEntity: ItemsEntity) {
        viewModelScope.launch {
            repository.addItem(itemsEntity)
        }
    }

    fun addParty(partyEntity: PartyEntity) {
        viewModelScope.launch {
            repository.addParty(partyEntity)
        }
    }

    fun changeSelectedType(type: Int) {
        selectedType.value = type
    }

}
