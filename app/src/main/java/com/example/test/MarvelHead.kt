package com.example.test

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Marvel() {
    Column(
        modifier = Modifier
            .background(Color(60, 60, 60))
            .fillMaxHeight(0.35f)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.marvel),
            contentDescription = "Marvel",
            modifier = Modifier
                .size(150.dp),
        )
        Text(text = "Choose your hero", color = Color.White, fontSize = 40.sp)

    }
}
