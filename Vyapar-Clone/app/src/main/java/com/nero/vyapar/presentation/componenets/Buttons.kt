package com.nero.vyapar.presentation.componenets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
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
            .width(110.dp)
            .height(30.dp)
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
                painter = painterResource(id = R.drawable.ic_baseline_add_24),
                contentDescription = null
            )
            //  Spacer(modifier = Modifier.size(5.dp))
            Text(
                text = name,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                color = Color(0xFF3076BD)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun previewButton() {
    Column {
        AddButton("New party", {},3)
    }
}