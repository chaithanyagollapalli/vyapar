package com.nero.vyapar.home_nav_bar.items

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nero.vyapar.R
import com.nero.vyapar.constants.Constants
import com.nero.vyapar.local.entity.ItemsEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_add_product.*


@AndroidEntryPoint
class AddProductFragment : Fragment() {


    private val addProductViewModel: AddProductViewModel by viewModels()
    private val pic_id = 123

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
                    etPurchasePrice.text.toString().toLong(), 0.2f, 10

                )

                addProductViewModel.addItem(itemsEntity)
                val action = AddProductFragmentDirections.actionAddProductFragmentToNavItems()
                findNavController().navigate(action)
            }
        }

        btnCancel.setOnClickListener {
            val action = AddProductFragmentDirections.actionAddProductFragmentToNavItems()
            findNavController().navigate(action)
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
        return isValid
    }

    companion object {

        fun newInstance() =
            AddProductFragment().apply {

            }
    }


}