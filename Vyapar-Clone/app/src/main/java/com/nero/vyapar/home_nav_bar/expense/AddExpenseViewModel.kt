package com.nero.vyapar.home_nav_bar.expense

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nero.vyapar.local.entity.ExpenseEntity
import com.nero.vyapar.repository.ItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddExpenseViewModel @Inject constructor(
    private val itemsRepository: ItemsRepository
) : ViewModel() {

    fun addExpense(expenseEntity: ExpenseEntity) {
        viewModelScope.launch {
            itemsRepository.addExpense(expenseEntity)
        }
    }

}