package com.example.test

import android.util.Log
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.clickable
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.test.navigation.Destination



@Composable
fun MarvelCard(item: MarvelCardModel, navController: NavHostController) {
        Card(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .size(320.dp, 440.dp)
                .clickable {
                    navController.navigate(Destination.Description.passId(item.id.toString()))
                    Log.i("deb", item.id.toString())
                },
            shape = RoundedCornerShape(15.dp)

        ) {
            AsyncImage(
                model = item.url,
                contentDescription = null,
                contentScale = ContentScale.Crop)

            Box(
                modifier = Modifier.fillMaxSize(),
                Alignment.BottomStart
            ) {
                Text(
                    text = item.title,
                    modifier = Modifier.padding(start = 30.dp, bottom = 40.dp),
                    style = TextStyle(color = Color.White, fontSize = 35.sp)
                )
            }
        }
    }
