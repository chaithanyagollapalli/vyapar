package com.nero.vyapar.home_nav_bar.sale

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import com.nero.vyapar.R
import com.nero.vyapar.databinding.SaleFragmentBinding

class SaleFragment : Fragment() {


    private lateinit var saleViewModel: SaleViewModel
    private var _binding: SaleFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        saleViewModel = ViewModelProvider(this).get(SaleViewModel::class.java)

        _binding = SaleFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        saleViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return inflater.inflate(R.layout.sale_fragment, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}