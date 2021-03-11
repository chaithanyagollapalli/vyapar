package com.nero.vyapar.home_nav_bar.purchase

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nero.vyapar.local.entity.TransactionEntity
import com.nero.vyapar.repository.ItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PurchaseSharedViewModel @Inject constructor(
    private val repository: ItemsRepository
) : ViewModel() {


    var listOfPurchase: MutableState<ArrayList<PurchaseDto>> = mutableStateOf(arrayListOf())

    fun addTransaction(transactionEntity: TransactionEntity) {
        viewModelScope.launch {
            repository.addTransaction(transactionEntity)
        }
        Log.d("salesshared", transactionEntity.billedItemNames!!)
        Log.d("salesshared", transactionEntity.billedItemQuantity!!)
    }

}