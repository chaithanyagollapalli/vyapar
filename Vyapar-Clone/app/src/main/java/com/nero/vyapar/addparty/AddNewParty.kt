package com.nero.vyapar.addparty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nero.vyapar.R
import com.nero.vyapar.addparty.adapter.PartiesViewPagerAdapter
import com.nero.vyapar.addparty.fragments.AddressesFragment
import com.nero.vyapar.addparty.fragments.GstFragment
import com.nero.vyapar.addparty.fragments.OpeningBalanceFragment
import com.nero.vyapar.viewmodel
import kotlinx.android.synthetic.main.activity_add_new_item.*
import kotlinx.android.synthetic.main.activity_add_new_item.view.*
import kotlinx.android.synthetic.main.fragment_addresses.*

class AddNewParty : AppCompatActivity() {

    lateinit var viewModel: viewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_item)

        viewPagerSetup()
        btnSave.setOnClickListener {
            val partyName = partyNameEditText.text.toString()
            val partyContact = contactNumberEditText.text.toString()
            val partyBillingAdd = billingAddressEditText.text.toString()

        }
    }

    private fun viewPagerSetup() {
        val adapter = PartiesViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(AddressesFragment(), "Addresses")
        adapter.addFragment(GstFragment(), "GST")
        adapter.addFragment(OpeningBalanceFragment(),"Opening Balance")
        viewPagerAddNewParty.adapter = adapter
        tabLayoutAddNewParty.setupWithViewPager(viewPagerAddNewParty)
    }
}