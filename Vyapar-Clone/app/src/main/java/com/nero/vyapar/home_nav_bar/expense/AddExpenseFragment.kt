package com.nero.vyapar.home_nav_bar.expense

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nero.vyapar.R
import com.nero.vyapar.local.entity.ExpenseEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_add_expense.*

@AndroidEntryPoint
class AddExpenseFragment : Fragment() {

    private val viewModel: AddExpenseViewModel by viewModels()

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

    companion object {

        fun newInstance() = AddExpenseFragment()
    }
}