package com.nero.vyapar.home_nav_bar.businessDashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BusinessDashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Business Dashboard Fragment"
    }
    val text: LiveData<String> = _text
}