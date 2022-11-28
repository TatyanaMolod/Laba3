package com.example.test.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.test.network.getMarvel
import com.example.test.screens.DescriptionScreen
import com.example.test.screens.StartScreen
import com.example.test.ErrorMessage


sealed class Destination(val route: String){
    object Start: Destination("Start")
    object Description: Destination("Description")

    fun passId(vararg args: String): String{
        return buildString{
            append(route)
            args.forEach{ arg ->
                append("/$arg")
            }
        }
    }
}



@Composable
fun NavigationAppHost() {
    val MarvelCardsItem = getMarvel()
    if (MarvelCardsItem[0].title == "Error") {
        ErrorMessage()
    } else {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Destination.Start.route) {
            composable(route = Destination.Start.route) {
                StartScreen(navController = navController, MarvelCardsItem) }
            composable(route = Destination.Description.route + "/{id}", arguments = listOf(navArgument("id") {
                type = NavType.IntType
            })) { value ->
                DescriptionScreen(navController = navController, id = value.arguments?.getInt("id"), MarvelCardsItem)
            }
        }
    }
}

