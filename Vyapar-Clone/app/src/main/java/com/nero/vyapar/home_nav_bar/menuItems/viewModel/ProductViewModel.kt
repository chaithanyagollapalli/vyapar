package com.nero.vyapar.home_nav_bar.menuItems.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nero.vyapar.local.entity.ExpenseEntity
import com.nero.vyapar.local.entity.ItemsEntity
import com.nero.vyapar.repository.ItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val itemsRepository: ItemsRepository) :
    ViewModel() {

    fun getItems(): LiveData<List<ItemsEntity>> {
        return itemsRepository.getAllItems()
    }
}