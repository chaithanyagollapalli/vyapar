package com.nero.vyapar.home_nav_bar.items

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nero.vyapar.presentation.componenets.ItemCard
import com.nero.vyapar.presentation.componenets.robotoFamily
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemsFragment : Fragment() {

    private val viewModel: ItemsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return ComposeView(requireContext()).apply {
            setContent {

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

@Composable
fun Selector(selected: Int) {

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {

        Card(
            modifier = Modifier
                .width(110.dp)
                .height(45.dp),
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(2.dp, color = Color(0xFFE36B4E)),
            backgroundColor = Color(0xFFFEE4DC)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Parties",
                    color = Color(0xFFE36B4E),
                    fontSize = 10.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Normal,
                )
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun preview() {
    Column {
        Selector(1)
    }
}


@Composable
fun SelectorCards(isSelected: Boolean,) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {

        Card(
            modifier = Modifier
                .width(110.dp)
                .height(45.dp),
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(2.dp, color = Color(0xFFE36B4E)),
            backgroundColor = Color(0xFFFEE4DC)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Parties",
                    color = Color(0xFFE36B4E),
                    fontSize = 10.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Normal,
                )
            }
        }

    }
}