package com.nero.vyapar.presentation.componenets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nero.vyapar.R

@Composable
fun AddButton(name: String, onClick: (Int) -> Unit, type: Int) {

    Card(
        modifier = Modifier
            .padding(end = 15.dp)
            .width(110.dp)
            .height(32.dp)
            .clickable {
                onClick(type)
            },
        shape = RoundedCornerShape(15.dp),
        backgroundColor = Color(0xFFE4EFFF),

        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Image(
                modifier = Modifier
                    .height(13.dp)
                    .width(13.dp),
                painter = painterResource(id = R.drawable.ic_baseline_add_24_blue),
                contentDescription = null
            )
            //  Spacer(modifier = Modifier.size(5.dp))
            Text(
                text = name,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp,
                color = Color(0xFF3076BD)
            )
        }
    }
}

@Composable
fun CircleAddButton(onClick: () -> Unit) {

    Image(
        painter = painterResource(id = R.drawable.ic_circle_plus),
        contentDescription = null,
        modifier = Modifier
            .height(45.dp)
            .width(45.dp)
            .clickable { onClick() }
    )

}


@Composable
fun SalePurchaseButton(
    backGroundColour: Color,
    name: String,
    onClick: () -> Unit
) {

    Button(
        onClick = { onClick() },
        modifier = Modifier
            .width(140.dp)
            .height(45.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = backGroundColour),
        shape = RoundedCornerShape(50)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_inner_plus),
                contentDescription = null,
                modifier = Modifier
                    .width(15.dp)
                    .height(15.dp)
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = name, fontFamily = robotoFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 10.sp,
                color = Color.White
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewButton() {
    Column {
        CircleAddButton({})
    }
}