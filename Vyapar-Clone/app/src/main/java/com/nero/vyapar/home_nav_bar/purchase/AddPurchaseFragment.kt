package com.nero.vyapar.home_nav_bar.purchase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.nero.vyapar.databinding.FragmentAddPurchaseBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AddPurchaseFragment : Fragment() {

    lateinit var _binding: FragmentAddPurchaseBinding
    private val binding: FragmentAddPurchaseBinding get() = _binding
    private val sharedViewModel: PurchaseSharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddPurchaseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {

            sharedViewModel.listOfPurchase.value.add(
                PurchaseDto(
                    binding.etProductName.text.toString(),
                    binding.etQuantity.text.toString().toInt(),
                    binding.etRate.text.toString().toLong()
                )
            )
            activity?.onBackPressed()
        }

    }


}