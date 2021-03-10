package com.nero.vyapar.home_nav_bar.items

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    }

    val selectedType: MutableState<Int> = mutableStateOf(0)

    var items: MutableState<List<ItemsEntity>> = mutableStateOf(listOf())
    var transcations: MutableState<List<TransactionEntity>> = mutableStateOf(listOf())
    var parties: MutableState<List<PartyEntity>> = mutableStateOf(listOf())

    fun getAllItems() {
        repository.getAllItems().observeForever() {
            items.value = it
        }
    }

    fun addItem(itemsEntity: ItemsEntity) {
        viewModelScope.launch {
            repository.addItem(itemsEntity)
        }
    }

    fun changeSelectedType(type: Int) {
        selectedType.value = type
    }

}
