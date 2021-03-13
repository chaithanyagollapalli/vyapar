package com.nero.vyapar.home_nav_bar.purchase

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.nero.vyapar.R
import com.nero.vyapar.databinding.FragmentAddPurchaseBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_add_purchase.*


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

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_line_item, menu)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            if (isDataValid()) {
                sharedViewModel.listOfPurchase.value.add(
                    PurchaseDto(
                        binding.etProductNamePurchaseFragment.text.toString(),
                        binding.etQuantityProductFrag.text.toString().toInt(),
                        binding.etRateProductFrag.text.toString().toLong()
                    )
                )
                activity?.onBackPressed()
            }

        }

        cvSaveAndNewPurchaseFragment.setOnClickListener {
            Toast.makeText(
                activity,
                "Item / services name cannot be left empty",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    private fun isDataValid(): Boolean {
        var isValid = true
        if (etProductNamePurchaseFragment.text.toString().isEmpty()) {
            etProductNamePurchaseFragment.error = "Required"
            isValid = false
        }
        if (etQuantityProductFrag.text.toString().isEmpty()) {
            etQuantityProductFrag.error = "Required"
            isValid = false
        }
        if (etRateProductFrag.text.toString().isEmpty()) {
            etRateProductFrag.error = "Required"
            isValid = false
        }


        return isValid
    }


}