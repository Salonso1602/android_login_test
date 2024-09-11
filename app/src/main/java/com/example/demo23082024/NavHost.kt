package com.example.demo23082024

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.demo23082024.ui.screens.LoginScreen

@Composable
fun OurNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String
) {
    NavHost(navController, startDestination, modifier = modifier) {
        composable("Screen1") {
            val context = LocalContext.current

            LoginScreen(
                onLoginClick = {
                    navController.navigate("Screen2/obligatorio?paramOpcional=true")
                },
                userNameState = remember { mutableStateOf("") },
                passwordState = remember { mutableStateOf("") },
//                onActivityNavigation = {
//                    val intent = Intent(context, SecondActivity::class.java).apply {
//                        putExtra(SecondActivity.PARAM, "Parámetro")
//                    }
//                    context.startActivity(intent)
//                }
                        )
        }
        composable(
            "Screen2/{paramObligatorio}?paramOpcional={paramOpcional}",
            arguments = listOf(
                navArgument("paramObligatorio") { type = NavType.StringType },
                navArgument("paramOpcional") {
                    type = NavType.BoolType
                    defaultValue = false
                }
            )
        ) { backStackEntry ->
            val obligatorio = backStackEntry.arguments?.getString("paramObligatorio")
            val opcional = backStackEntry.arguments?.getBoolean("paramOpcional")
//            Screen2 {
//                navController.popBackStack()
//            }
        }
    }
}