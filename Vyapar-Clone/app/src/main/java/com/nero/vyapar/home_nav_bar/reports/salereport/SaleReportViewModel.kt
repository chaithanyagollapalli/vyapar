package com.nero.vyapar.home_nav_bar.reports.salereport

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nero.vyapar.local.entity.TransactionEntity
import com.nero.vyapar.repository.ItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SaleReportViewModel @Inject constructor(
    private var repository: ItemsRepository
) : ViewModel() {

    fun getSalesReport() {
        viewModelScope.launch {
            repository.getAllTransactions()
        }
    }

}