package com.nero.vyapar.presentation.componenets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
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
import com.nero.vyapar.constants.Constants
import com.nero.vyapar.local.entity.ItemsEntity
import com.nero.vyapar.local.entity.PartyEntity
import com.nero.vyapar.local.entity.TransactionEntity
import kotlin.math.abs


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
                    Spacer(modifier = Modifier.size(5.dp))
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
                    Spacer(modifier = Modifier.size(5.dp))
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

@Composable
fun TransactionCard(
    transactionEntity: TransactionEntity, onClick: (TransactionEntity) -> Unit
) {
    Card(
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth()
            .clickable { onClick(transactionEntity) },
    ) {
        Column(modifier = Modifier.padding(start = 10.dp)) {
            Text(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(0.9f),
                text = transactionEntity.partyName!!,
                fontSize = 15.sp,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Medium
            )
            //0xFF
            //0xFFD1F2E7
            Spacer(modifier = Modifier.size(5.dp))
            Surface(
                modifier = Modifier.height(20.dp),
                shape = MaterialTheme.shapes.small,
                color = if (transactionEntity.type == "purchase") Color(0xFFFEE4DC) else Color(
                    0xFFD1F2E7
                )
            ) {
                if (transactionEntity.type == "purchase") {
                    Text(
                        text = "PURCHASE",
                        modifier = Modifier.padding(3.dp),
                        color = Color(0xFFE36B4E),
                        fontSize = 10.sp
                    )
                } else {
                    Text(
                        text = "SALE",
                        modifier = Modifier.padding(3.dp),
                        color = Color(0xFF26B180),
                        fontSize = 10.sp
                    )
                }
            }
            Spacer(modifier = Modifier.size(15.dp))


            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {

                Row {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Total",
                            fontSize = 10.sp,
                            fontFamily = robotoFamily,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.size(5.dp))
                        Text(
                            text = "₹ "+transactionEntity.total.toString(),
                            fontSize = 15.sp,
                            fontFamily = robotoFamily,
                            fontWeight = FontWeight.Normal
                        )
                    }

                    Spacer(modifier = Modifier.size(50.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Balance",
                            fontSize = 10.sp,
                            fontFamily = robotoFamily,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.size(5.dp))
                        Text(
                            text = "₹ "+(transactionEntity.total!! - (transactionEntity.received!!)).toString(),
                            fontSize = 15.sp,
                            fontFamily = robotoFamily,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
                Row {
                    Image(
                        modifier = Modifier
                            .padding(top = 10.dp, end = 10.dp)
                            .height(20.dp)
                            .width(20.dp),
                        painter = painterResource(id = R.drawable.ic_print),
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )
                    Image(
                        modifier = Modifier
                            .padding(top = 10.dp, end = 10.dp)
                            .height(20.dp)
                            .width(20.dp),
                        painter = painterResource(id = R.drawable.ic_share),
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )
                    Image(
                        modifier = Modifier
                            .padding(top = 10.dp, end = 10.dp)
                            .height(20.dp)
                            .width(20.dp),
                        painter = painterResource(id = R.drawable.ic_more),
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )
                }
            }
            Divider(color = Color.Black)
        }
    }
}

@Composable
fun PartiesCard(partyEntity: PartyEntity, onClick: (PartyEntity) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .clickable { onClick(partyEntity) },
        ) {

            Row(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {

                Text(
                    text = partyEntity.partyName!!,
                    fontSize = 15.sp,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Medium
                )
                Column(
                    modifier = Modifier
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = abs(partyEntity.amout!!).toString(),
                        fontSize = 15.sp,
                        fontFamily = robotoFamily,
                        fontWeight = FontWeight.Medium,
                        color = if (partyEntity.amout!! > 0) Color(0xFF26B180) else Color(0xFFE36B4E)
                    )
                    Spacer(modifier = Modifier.size(5.dp))
                    Text(
                        text = if (partyEntity.amout!! > 0) "You'll Get" else "You'll Give",
                        fontSize = 10.sp,
                        fontFamily = robotoFamily,
                        fontWeight = FontWeight.Normal,
                        color = if (partyEntity.amout!! > 0) Color(0xFF26B180) else Color(0xFFE36B4E)
                    )
                }

            }
        }
        Divider(color = Color.LightGray,thickness = 0.5.dp,)
    }

}

@Preview(showBackground = true)
@Composable
fun preview() {
    Column {

        TransactionCard(transactionEntity =
        TransactionEntity(
            54,
            Constants.PURCHASE,
            "batman",
            "cola,car",
            "10,15",
            1000,
            500,
            1000
        ), onClick = { /*TODO*/ })
        TransactionCard(transactionEntity =
        TransactionEntity(
            54,
            Constants.SALE,
            "batman",
            "cola,car",
            "10,15",
            1000,
            500,
            1000
        ), onClick = { /*TODO*/ })

    }
}