package com.nero.vyapar.home_nav_bar.menuItems

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.nero.vyapar.databinding.FragmentProductBinding
import com.nero.vyapar.home_nav_bar.items.AddProductFragment
import com.nero.vyapar.home_nav_bar.menuItems.adapters.ProductsAdapter
import com.nero.vyapar.home_nav_bar.menuItems.onClick.OnItemClick
import com.nero.vyapar.home_nav_bar.menuItems.viewModel.ProductViewModel
import com.nero.vyapar.local.entity.ItemsEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_product.*

@AndroidEntryPoint
class ProductFragment : Fragment(), OnItemClick {

    private lateinit var _binding: FragmentProductBinding
    private val binding: FragmentProductBinding get() = _binding

    val viewModel: ProductViewModel by viewModels()
    private val itemList = mutableListOf<ItemsEntity>()
    val adapter = ProductsAdapter(itemList, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductBinding.inflate(inflater, container, false)
        return _binding.root
        // Inflate the layout for this fragment

//        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    companion object {
        fun newInstance() = ProductFragment()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getItems().observe(this, Observer {
            itemList.clear()
            itemList.addAll(it)
            adapter.notifyDataSetChanged()
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.productsRecyclerView.adapter = adapter
        binding.productsRecyclerView.layoutManager = LinearLayoutManager(context)



        btnAddProduct.setOnClickListener {

            val action = MenuItemsFragmentDirections.actionNavHomeToAddProductFragment(null)
            Navigation.findNavController(binding.root).navigate(action)


        }
    }

    override fun onClickShare(itemsEntity: ItemsEntity) {
        val myIntent = Intent(Intent.ACTION_SEND)
        myIntent.setType("text/plain");
        val name =
            "Item Details:  \n " +
                    "Name: ${itemsEntity.name}\n Sales Price: ${itemsEntity.salePrice}\n " +
                    " Purchase Price: ${itemsEntity.purchasePrice}\n" +
                    " Stock quantity: ${itemsEntity.stock} \n"

        myIntent.putExtra(Intent.EXTRA_TEXT, name);
        startActivity(Intent.createChooser(myIntent, "Share Using"))


    }

    override fun onEditClick(itemsEntity: ItemsEntity) {


        val actipon = MenuItemsFragmentDirections.actionNavHomeToAddProductFragment(itemsEntity)
        Navigation.findNavController(binding.root).navigate(actipon)

    }


}