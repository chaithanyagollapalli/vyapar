package com.nero.vyapar.home_nav_bar.expense

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nero.vyapar.R
import com.nero.vyapar.local.entity.ExpenseEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_add_expense.*
import kotlinx.android.synthetic.main.fragment_add_expense.etItemName
import kotlinx.android.synthetic.main.fragment_add_product.*
import kotlinx.android.synthetic.main.fragment_add_purchase.*

@AndroidEntryPoint
class AddExpenseFragment : Fragment() {

    private val viewModel: AddExpenseViewModel by viewModels()
    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_line_item , menu)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_expense, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var qty: Int = 0
        var price: Int = 0

        etQty.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                qty = etQty.text.toString().toInt()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        etPrice.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                price = etPrice.text.toString().toInt()
                val amt = (qty * price).toString()
                etTotalAmt.setText(amt)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        btnAddExpenseSave.setOnClickListener {

            if (isDataValid()){

            val expenseEntity = ExpenseEntity(
                etExpenseCategory.text.toString(),
                etItemName.text.toString(),
                etQty.text.toString().toInt(),
                etPrice.text.toString().toInt(),
                etTotalAmt.text.toString().toInt()
            )
                viewModel.addExpense(expenseEntity)
                val action = AddExpenseFragmentDirections.actionAddExpenseFragmentToNavExpenses()
                findNavController().navigate(action)
            }

        }

        btnAddExpenseSaveAndNew.setOnClickListener {
            Toast.makeText(
                activity,
                "Item / services name cannot be left empty",
                Toast.LENGTH_SHORT
            ).show()
        }

    }
    private fun isDataValid(): Boolean {
        var isValid = true
        if (etItemName.text.toString().isEmpty()) {
            etItemName.error = "Required"
            isValid = false
        }
        if (etQty.text.toString().isEmpty()) {
            etQty.error = "Required"
            isValid = false
        }
        if (etPrice.text.toString().isEmpty()) {
            etPrice.error = "Required"
            isValid = false
        }
        if (etTotalAmt.text.toString().isEmpty()) {
            etTotalAmt.error = "required"
            isValid = false
        }
        if (etExpenseCategory.text.toString().isEmpty()) {
            etExpenseCategory.error = "required"
            isValid = false
        }


        return isValid
    }

    companion object {

        fun newInstance() = AddExpenseFragment()
    }
}