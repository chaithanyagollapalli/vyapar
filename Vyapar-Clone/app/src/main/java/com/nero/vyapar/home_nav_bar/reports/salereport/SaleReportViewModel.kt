package com.nero.vyapar.home_nav_bar.reports.salereport

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nero.vyapar.local.entity.ExpenseEntity
import com.nero.vyapar.local.entity.TransactionEntity
import com.nero.vyapar.repository.ItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SaleReportViewModel @Inject constructor(
    private var itemRepository: ItemsRepository
) : ViewModel() {

    fun getReport(): LiveData<List<TransactionEntity>> {
        return itemRepository.getAllTransactions()
    }

}