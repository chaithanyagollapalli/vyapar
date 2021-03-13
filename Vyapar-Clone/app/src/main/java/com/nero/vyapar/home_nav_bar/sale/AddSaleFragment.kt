package com.nero.vyapar.home_nav_bar.sale

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.nero.vyapar.databinding.FragmentAddSaleBinding
import kotlinx.android.synthetic.main.fragment_add_product.*
import kotlinx.android.synthetic.main.fragment_add_sale.*


class AddSaleFragment : Fragment() {

    lateinit var _binding: FragmentAddSaleBinding
    val binding: FragmentAddSaleBinding get() = _binding
    private val sharedViewModel: SaleSharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //hiding the action bar

        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        _binding = FragmentAddSaleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {

            if (isDataValid()) {
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

        ivBackBtn.setOnClickListener {
            val action = AddSaleFragmentDirections.actionAddSaleFragmentToNavSale()
            findNavController().navigate(action)
        }
        ivSettings.setOnClickListener {
            val action = AddSaleFragmentDirections.actionAddSaleFragmentToNavSettings()
            findNavController().navigate(action)
        }

        cvSaveAndNew.setOnClickListener {
            Toast.makeText(
                activity,
                "Item / services name cannot be left empty",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    override fun onResume() {
        super.onResume()
        //hiding the nav bar
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    private fun isDataValid(): Boolean {
        var isValid = true
        if (etProductName.text.toString().isEmpty()) {
            etProductName.error = "Required"
            isValid = false
        }
        if (etQuantity.text.toString().isEmpty()) {
            etQuantity.error = "Required"
            isValid = false
        }
        if (etRate.text.toString().isEmpty()) {
            etRate.error = "Required"
            isValid = false
        }


        return isValid
    }

}