package com.nero.vyapar.home_nav_bar.party

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.nero.vyapar.R
import com.nero.vyapar.home_nav_bar.party.adapter.PartiesViewPagerAdapter
import com.nero.vyapar.local.entity.PartyEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_add_new_party.*
import kotlinx.android.synthetic.main.fragment_addresses.*
import kotlinx.android.synthetic.main.fragment_opening_balance.*
import java.lang.Integer.parseInt
import java.lang.Long.parseLong

@AndroidEntryPoint
class AddNewPartyFragment : Fragment() {

    private val partiesViewModel: PartiesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_new_party, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val viewPageAdapter = PartiesViewPagerAdapter(this.parentFragmentManager)
        viewPagerAddNewParty.adapter = viewPageAdapter

    /*    TabLayoutMediator(tabLayoutAddNewParty,viewPagerAddNewParty){       //TODO - asking for viewpager2
                tab,position ->
            tab.text = when(position) {
                0 -> "Addresses"
                1 -> "GST"
                2 -> "Opening Balance"
                else -> "Addresses"
            }
        }.attach()


     */
        var partyName: String = ""
        var contactNo: String = ""
        var billingAdd: String = ""
        var amount: Long = 0

        btnSave.setOnClickListener {
            if (isDataValid()){
                partyName = partyNameEditText.text.toString()
                contactNo = contactNumberEditText.text.toString()
                billingAdd = billingAddressEditText.text.toString()
                amount = parseLong(openingBalanceEditText.text.toString())

                var partyEntity = PartyEntity(partyName,contactNo,billingAdd,amount)
                partiesViewModel.addParty(partyEntity)
            }
        }

    }

    private fun isDataValid(): Boolean {
        if (partyNameEditText.text == null)
            return false
        if (billingAddressEditText.text == null)
            return false
        if (contactNumberEditText.text == null || contactNumberEditText.text.toString().length != 10)
            return false
        if (openingBalanceEditText.text == null)
            return false

        return true
    }

}