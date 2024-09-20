package com.example.demo23082024

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.demo23082024.entities.JoinableActivity
import com.example.demo23082024.entities.User
import com.example.demo23082024.ui.components.ConfirmationDialog
import com.example.demo23082024.ui.screens.HomeScreen
import com.example.demo23082024.ui.screens.LoginScreen
import com.example.demo23082024.ui.screens.ProfileInfoScreen
import java.time.LocalDateTime

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