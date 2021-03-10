package com.nero.vyapar.home_nav_bar.businessDashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nero.vyapar.databinding.FragmentBusinessDashboardBinding

class BusinessDashboardFragment : Fragment() {

    private lateinit var businessDashboardViewModel: BusinessDashboardViewModel
    private var _binding: FragmentBusinessDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        businessDashboardViewModel =
            ViewModelProvider(this).get(BusinessDashboardViewModel::class.java)

        _binding = FragmentBusinessDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGallery
        businessDashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}