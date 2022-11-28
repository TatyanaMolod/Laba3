package com.example.test.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.test.Cards
import com.example.test.Marvel
import com.example.test.MarvelCardModel


@Composable
fun StartScreen(navController: NavHostController, MarvelCardsItem: List<MarvelCardModel>) {
    Column(
        modifier = Modifier
            .background(Color(60, 60, 60))
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Marvel()
        Cards(navController = navController, MarvelCardsItem)

    }
}