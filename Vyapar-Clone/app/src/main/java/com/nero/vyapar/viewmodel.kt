package com.nero.vyapar

import androidx.lifecycle.ViewModel
import com.nero.vyapar.local.database.VyaparDatabase
import com.nero.vyapar.repository.ItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class viewmodel @Inject constructor(
    database: ItemsRepository
) : ViewModel() {

    val data = database.data

}