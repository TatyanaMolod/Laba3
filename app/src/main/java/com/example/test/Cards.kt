package com.example.test

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior

@Composable
@OptIn(ExperimentalSnapperApi::class)
fun Cards(navController : NavHostController, MarvelCardsItem: List<MarvelCardModel>) {

    val listState = rememberLazyListState()
    LazyRow(
        state = listState,
        flingBehavior = rememberSnapperFlingBehavior(listState),

    )
    {

        itemsIndexed(MarvelCardsItem) {_, item ->
            MarvelCard(item, navController)
                    }

        }
    }
