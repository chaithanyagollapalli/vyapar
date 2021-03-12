package com.nero.vyapar.home_nav_bar.sale

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.nero.vyapar.databinding.FragmentAddSaleBinding

class AddSaleFragment : Fragment() {

    lateinit var _binding: FragmentAddSaleBinding
    val binding: FragmentAddSaleBinding get() = _binding
    private val sharedViewModel: SaleSharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddSaleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {

            sharedViewModel.listOfSale.value.add(
                SaleDTO(
                    binding.etProductName.text.toString(),
                    binding.etQuantity.text.toString().toInt(),
                    binding.etRate.text.toString().toLong()
                )
            )
            activity?.onBackPressed()
        }
    }
}