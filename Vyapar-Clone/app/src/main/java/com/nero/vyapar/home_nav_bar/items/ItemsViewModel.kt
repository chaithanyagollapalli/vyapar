package com.nero.vyapar.home_nav_bar.items

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is item Fragment"
    }
    val text: LiveData<String> = _text
}