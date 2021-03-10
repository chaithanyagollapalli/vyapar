package com.nero.vyapar.home_nav_bar.sale

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SaleViewModel :  ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Sales Fragment"
    }
    val text: LiveData<String> = _text
}