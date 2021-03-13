package com.nero.vyapar.home_nav_bar.items

import android.app.ActionBar
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.nero.vyapar.R
import com.nero.vyapar.constants.Constants
import com.nero.vyapar.local.entity.ItemsEntity
import com.nero.vyapar.viewmodel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_add_product.*


@AndroidEntryPoint
class AddProductFragment : Fragment() {


    private val addProductViewModel: AddProductViewModel by viewModels()
    private val pic_id = 123
    private val args by navArgs<AddProductFragmentArgs>()

    private var editMode = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_add_product, container, false)


    }

    //calling the menu on action bar
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_product, menu)

    }

    // selection of camera btn and setting btn
    //what will happen
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_camera -> {

                //opening the camera and taking the photo
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(cameraIntent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        btnSaveAddProduct.setOnClickListener {

            if (isDataValid()) {
                val itemsEntity = ItemsEntity(

                    etItemName.text.toString(),
                    Constants.PRODUCT,
                    etItemCode.text.toString(),
                    etHSN.text.toString(),
                    etSalePrice.text.toString().toLong(),
                    etPurchasePrice.text.toString().toLong(),
                    0.2f,
                    etStockQuantity.text.toString().toLong()

                )

                if (!editMode) {
                    addProductViewModel.addItem(itemsEntity)
                } else {
                    if (isDataValid()) {

                        args.itemdetails?.name = etItemName.text.toString()
                        args.itemdetails?.itemCode = etItemCode.text.toString()
                        args.itemdetails?.salePrice = etSalePrice.text.toString().toLong()
                        args.itemdetails?.sacCode = etHSN.text.toString()
                        args.itemdetails?.purchasePrice = etPurchasePrice.text.toString().toLong()
                        args.itemdetails?.stock = etStockQuantity.text.toString().toLong()
                        addProductViewModel.updateItem(args.itemdetails!!)
                    }
                }
                activity?.onBackPressed()

            }
        }

        btnCancel.setOnClickListener {
            activity?.onBackPressed()

        }

        //editing values
        if (args.itemdetails != null) {

            etItemName.setText(args.itemdetails!!.name)
            etItemCode.setText(args.itemdetails!!.itemCode.toString())
            etSalePrice.setText(args.itemdetails!!.salePrice.toString())
            etStockQuantity.setText(args.itemdetails!!.stock.toString())
            etPurchasePrice.setText(args.itemdetails!!.purchasePrice.toString())
            editMode = true
        }


    }


    private fun isDataValid(): Boolean {
        var isValid = true
        if (etItemName.text.toString().isEmpty()) {
            etItemName.error = "Required"
            isValid = false
        }
        if (etItemCode.text.toString().isEmpty()) {
            etItemCode.error = "Required"
            isValid = false
        }
        if (etSalePrice.text.toString().isEmpty()) {
            etSalePrice.error = "Required"
            isValid = false
        }
        if (etPurchasePrice.text.toString().isEmpty()) {
            etPurchasePrice.error = "required"
            isValid = false
        }
        if (etHSN.text.toString().isEmpty()) {
            etHSN.error = "required"
            isValid = false
        }
        if (etTax.toString().isEmpty()) {
            etTax.error = "required"
            isValid = false
        }

        return isValid
    }


    companion object {

        fun newInstance() =
            AddProductFragment().apply {

            }
    }


}