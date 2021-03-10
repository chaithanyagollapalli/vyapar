package com.nero.vyapar.home_nav_bar.items

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nero.vyapar.local.entity.ItemsEntity
import com.nero.vyapar.presentation.componenets.ItemCard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemsFragment : Fragment() {

    /*  private lateinit var itemsViewModel: ItemsViewModel
      private var _binding: FragmentItemBinding? = null

      // This property is only valid between onCreateView and
      // onDestroyView.
      private val binding get() = _binding!!*/
    private val viewModel: ItemsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*    itemsViewModel =
                ViewModelProvider(this).get(ItemsViewModel::class.java)*/

        /* _binding = FragmentItemBinding.inflate(inflater, container, false)
         val root: View = binding.root
         val textView: TextView = binding.textHome*/

        return ComposeView(requireContext()).apply {
            setContent {
                val items: List<ItemsEntity> = listOf()
                LazyColumn() {
                    itemsIndexed(
                        items = viewModel.items.value
                    ) { index, itemEntity ->
                        ItemCard(itemEntity = itemEntity, onClick = { /*TODO*/ })
                    }
                }
            }
        }
    }

}