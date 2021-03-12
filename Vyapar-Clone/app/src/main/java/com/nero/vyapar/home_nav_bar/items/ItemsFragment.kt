package com.nero.vyapar.home_nav_bar.items

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.*
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.nero.vyapar.R
import com.nero.vyapar.constants.Constants
import com.nero.vyapar.presentation.componenets.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemsFragment : Fragment() {

    private fun addItem(item: Int) {
        if (item == 2) {
            val action = ItemsFragmentDirections.actionNavItemsToAddProductFragment()
            findNavController().navigate(action)
        }
    }

    private val viewModel: ItemsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return ComposeView(requireContext()).apply {
            setContent {

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .background(Color.White),
                ) {
                    Column {

                        Row(
                            modifier = Modifier
                                .horizontalScroll(rememberScrollState())
                                .padding(bottom = 35.dp, top = 5.dp)
                        ) {
                            Spacer(modifier = Modifier.size(10.dp))
                            TotalInformationCard(
                                name = "You'll Get",
                                viewModel.totalToGet.value,
                                R.drawable.ic_arrow_downward,
                                Constants.YOUWILLGETINT,
                                { })
                            Spacer(modifier = Modifier.size(10.dp))

                            TotalInformationCard(
                                name = "Sale",
                                viewModel.totalSale.value,
                                R.drawable.ic_bill,
                                Constants.SALEINT,
                                { })
                            Spacer(modifier = Modifier.size(10.dp))

                            TotalInformationCard(
                                name = "You'll Give",
                                viewModel.totalToGive.value,
                                R.drawable.ic_upward,
                                Constants.YOUWILLGIVEINT,
                                { })
                            Spacer(modifier = Modifier.size(10.dp))

                            TotalInformationCard(
                                name = "Purchase",
                                viewModel.totalPurchase.value,
                                R.drawable.ic_shopping_cart,
                                Constants.PURCHASEINT,
                                { })
                            Spacer(modifier = Modifier.size(10.dp))

                            TotalInformationCard(
                                name = "Expense",
                                viewModel.totalExpenses.value,
                                R.drawable.ic_wallet,
                                Constants.PURCHASEINT,
                                { })
                            Spacer(modifier = Modifier.size(10.dp))


                        }

                        Selector(viewModel.selectedType.value) {
                            viewModel.changeSelectedType(it)
                        }

                        if (viewModel.selectedType.value == 0 || viewModel.selectedType.value == 2) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(55.dp),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                if (viewModel.selectedType.value == 0) {
                                    AddButton(name = "New Party", onClick = { /*TODO*/ }, type = 0)
                                } else if (viewModel.selectedType.value == 2) {
                                    AddButton(name = "New Item", onClick = {
                                        addItem(it)
                                    }, type = 2)
                                }
                            }
                        } else {
                            Spacer(modifier = Modifier.size(25.dp))
                        }

                        if (viewModel.selectedType.value == 2) {
                            LazyColumn() {
                                itemsIndexed(
                                    items = viewModel.items.value
                                ) { index, itemEntity ->
                                    ItemCard(itemEntity = itemEntity, onClick = { /*TODO*/ })
                                }
                            }
                        } else if (viewModel.selectedType.value == 0) {
                            LazyColumn() {
                                itemsIndexed(
                                    items = viewModel.parties.value
                                ) { index, party ->
                                    PartiesCard(partyEntity = party, onClick = { /*TODO*/ })
                                }
                            }
                        } else if (viewModel.selectedType.value == 1) {
                            LazyColumn() {
                                itemsIndexed(
                                    items = viewModel.transcations.value
                                ) { index, transaction ->
                                    TransactionCard(
                                        transactionEntity = transaction,
                                        onClick = { /*TODO*/ })
                                }
                            }
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    BottomButtons(
                        { navigateToPurchaseFragment() },
                        { openBottomSheet() },
                        { navigateToSaleFragment() })
                    Spacer(modifier = Modifier.size(15.dp))
                }
            }
        }
    }

    private fun openBottomSheet() {
        val bottomSheetDialog =
            context?.let { BottomSheetDialog(it, R.style.BottomSheetDialogTheme) }

        val view = layoutInflater.inflate(
            R.layout.bottom_sheet_layout, activity?.findViewById(R.id.llBottomConatainer)
        )
        bottomSheetDialog?.setContentView(view)
        bottomSheetDialog?.setCanceledOnTouchOutside(true)
        bottomSheetDialog?.show()
    }

    private fun navigateToSaleFragment() {
        val action = ItemsFragmentDirections.actionNavItemsToNavSale()
        findNavController().navigate(action)
    }

    private fun navigateToPurchaseFragment() {
        val action = ItemsFragmentDirections.actionNavItemsToNavPurchase()
        findNavController().navigate(action)
    }

}


@Composable
fun Selector(selected: Int, onClick: (Int) -> Unit) {

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        SelectorCards(selected == 0, "Parties", 0, onClick = onClick)
        SelectorCards(selected == 1, "Transactions", 1, onClick = onClick)
        SelectorCards(selected == 2, "Items", 2, onClick = onClick)
    }

}

@Composable
fun SelectorCards(isSelected: Boolean, name: String, nameCode: Int, onClick: (Int) -> Unit) {
    Row {
        Card(
            modifier = Modifier
                .width(110.dp)
                .height(35.dp)
                .clickable { onClick(nameCode) },
            shape = RoundedCornerShape(17.dp),
            border = BorderStroke(
                1.dp,
                color = if (isSelected) Color(0xFFCE2848) else Color.LightGray
            ),
            backgroundColor = if (isSelected) Color(0xFFF9DCE1) else Color.White
        ) {

            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = name,
                    color = if (isSelected) Color(0xFFCE2848) else Color.LightGray,
                    fontSize = 10.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Normal,
                )
            }
        }
    }
}


@Composable
fun TotalInformationCard(name: String, total: Long, image: Int, type: Int, onClick: (Int) -> Unit) {

    Card(
        modifier = Modifier
            .height(80.dp)
            .clickable { onClick(type) },
        shape = RoundedCornerShape(5.dp),
        elevation = 10.dp
    ) {

        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center

        ) {

            Row {
                Spacer(modifier = Modifier.width(15.dp))
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = image),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(3.dp))
                Text(
                    text = name,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp,
                    color = Color.LightGray
                )
                Spacer(modifier = Modifier.width(40.dp))
            }
            Spacer(modifier = Modifier.size(10.dp))
            Row() {
                Spacer(modifier = Modifier.width(38.dp))
                Text(
                    text = "₹ $total",
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.width(20.dp))
            }

        }

    }

}

@Composable
fun BottomButtons(
    onClickPurchase: () -> Unit,
    onClickMiddle: () -> Unit,
    onClickSale: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly

    ) {
        SalePurchaseButton(Color(0xFF0174E7), "Purchase", onClickPurchase)
        CircleAddButton(onClick = onClickMiddle)
        SalePurchaseButton(Color(0xFFED1A3B), "Add Sale", onClickSale)
    }
}


@Preview(showBackground = true)
@Composable
fun preview() {
    Column {

        BottomButtons({}, {}, {})

        // TotalInformationCard("you'll get", 1000, R.drawable.ic_arrow_downward, 3, {})
    }
}
