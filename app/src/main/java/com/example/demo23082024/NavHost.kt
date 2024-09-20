package com.example.demo23082024

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun OurNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String,
    composables: MutableMap<String, @Composable () -> Unit>
) {
    NavHost(navController, startDestination, modifier = modifier) {
        composables.forEach{
            val item = it
            composable(item.key){ item.value() }
        }
    }
}