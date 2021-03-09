package com.nero.vyapar.home_nav_bar.myOnlineStore

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nero.vyapar.R

class MyOnlineStoreFragment : Fragment() {

    companion object {
        fun newInstance() = MyOnlineStoreFragment()
    }

    private lateinit var viewModel: MyOnlineStoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.my_online_store_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MyOnlineStoreViewModel::class.java)
        // TODO: Use the ViewModel
    }

}