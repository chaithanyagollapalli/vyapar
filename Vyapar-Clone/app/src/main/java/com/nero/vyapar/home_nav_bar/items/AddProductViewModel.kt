package com.nero.vyapar.home_nav_bar.items

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nero.vyapar.local.entity.ItemsEntity
import com.nero.vyapar.repository.ItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class AddProductViewModel @Inject constructor(
    private val repository: ItemsRepository
) : ViewModel() {

    fun addItem(itemsEntity: ItemsEntity) {
        viewModelScope.launch {
            repository.addItem(itemsEntity)
        }
    }


}