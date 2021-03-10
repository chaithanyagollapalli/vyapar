package com.nero.vyapar.home_nav_bar.items

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nero.vyapar.local.entity.ItemsEntity
import com.nero.vyapar.repository.ItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(
    private val repository: ItemsRepository
) : ViewModel() {

    init {
        getAllItems()
    }

    var items: MutableState<List<ItemsEntity>> = mutableStateOf(listOf())

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

}