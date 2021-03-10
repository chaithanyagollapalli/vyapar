package com.nero.vyapar.presentation.componenets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nero.vyapar.R
import com.nero.vyapar.local.entity.ItemsEntity


val robotoFamily = FontFamily(
    Font(R.font.robotomedium, FontWeight.Medium),
    Font(R.font.roboto, FontWeight.Normal)
)

@Composable
fun ItemCard(itemEntity: ItemsEntity, onClick: (ItemsEntity) -> Unit) {

    Card(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .clickable { onClick(itemEntity) },
    ) {
        Column(modifier = Modifier.padding(start = 10.dp)) {

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth(0.9f),
                    text = itemEntity.name!!,
                    fontSize = 15.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Medium
                )
                Image(
                    modifier = Modifier
                        .padding(top = 10.dp, end = 10.dp)
                        .height(15.dp)
                        .width(15.dp),
                    painter = painterResource(id = R.drawable.ic_share),
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )
            }


            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.73f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Sale price",
                        fontSize = 10.sp,
                        fontFamily = robotoFamily,
                        fontWeight = FontWeight.Medium,
                        color = Color.Gray

                    )
                    Spacer(modifier = Modifier.size(5.dp))
                    Text(
                        text = itemEntity.salePrice.toString(),
                        fontSize = 15.sp,
                        fontFamily = robotoFamily,
                        fontWeight = FontWeight.Normal,
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Purchase price",
                        fontSize = 10.sp,
                        fontFamily = robotoFamily,
                        fontWeight = FontWeight.Medium,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(
                        text = itemEntity.purchasePrice.toString(),
                        fontSize = 15.sp,
                        fontFamily = robotoFamily,
                        fontWeight = FontWeight.Normal,
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "In Stock",
                        fontSize = 10.sp,
                        fontFamily = robotoFamily,
                        fontWeight = FontWeight.Medium,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(
                        text = itemEntity.stock.toString(),
                        fontSize = 15.sp,
                        fontFamily = robotoFamily,
                        fontWeight = FontWeight.Normal
                    )
                }

            }
            Divider(color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGreeting() {
    Column {
        ItemCard(ItemsEntity("cola", "product", "dfs", "dfs", 21, 80, 0.3f, 20), { })
        ItemCard(ItemsEntity("cola", "product", "dfs", "dfs", 21, 80, 0.3f, 20), { })
        ItemCard(ItemsEntity("cola", "product", "dfs", "dfs", 21, 80, 0.3f, 20), { })
    }
}