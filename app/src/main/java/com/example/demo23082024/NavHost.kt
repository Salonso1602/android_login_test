package com.example.demo23082024

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.demo23082024.ui.components.ConfirmationDialog
import com.example.demo23082024.ui.screens.HomeScreen
import com.example.demo23082024.ui.screens.LoginScreen

@Composable
fun OurNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String
) {
    // activity specific context, could be migrated to state machine or service
    val userName = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    NavHost(navController, startDestination, modifier = modifier) {
        composable("Login") {
            val context = LocalContext.current


            LoginScreen(
                onLoginClick = {
                    if(userName.value.contains("@test.com") && password.value == "Password123") {
                        navController.navigate("Home")
                    }
                    else {
                        Toast.makeText(context, "Incorrect Username or Password", Toast.LENGTH_SHORT).show()
                    }
                },
                userNameState = userName,
                passwordState = password,
            )
        }
        composable("Home") {
            val openAlertDialog = remember { mutableStateOf(false) }
            ConfirmationDialog(
                onConfirmation = {
                    password.value = ""
                    navController.navigate("Login")
                },
                openAlertDialog = openAlertDialog
            )
            HomeScreen(
                userNameState = userName,
                onLogoutClick = {
                    openAlertDialog.value = true
                }
            )
        }
    }
}