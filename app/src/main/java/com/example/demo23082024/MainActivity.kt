package com.example.demo23082024

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.example.demo23082024.entities.JoinableActivity
import com.example.demo23082024.entities.User
import com.example.demo23082024.ui.components.ConfirmationDialog
import com.example.demo23082024.ui.screens.HomeScreen
import com.example.demo23082024.ui.screens.LoginScreen
import com.example.demo23082024.ui.screens.ProfileInfoScreen
import com.example.demo23082024.ui.theme.Demo23082024Theme
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Demo23082024Theme {
                val navController = rememberNavController()
                val currentUser = remember { mutableStateOf(User(
                    name = "Lionel",
                    lastname = "Messi",
                    pfpId = R.drawable.download,
                    dob = LocalDateTime.parse("1987-01-06T20:30:10"),
                    country = "Argentina"
                )) }
                // activity specific context, could be migrated to state machine or service
                val userName = remember { mutableStateOf("") }
                val password = remember { mutableStateOf("") }
                val activity = remember {
                    mutableStateOf(
                        JoinableActivity(
                            name = "Cochabamba Cleanup",
                            shortDescription = "Cochabamba \nClean City \nTogether",
                            longDescription = "Hi Altiplaneros, We wait you to join with us. \n" +
                                    "We need you to save our city stay clean and beautiful.\n" +
                                    "Let's join Altiplaneros!",
                            location = "Cochabamba, BOL",
                            date = LocalDateTime.now(),
                            joinedMembers = mutableStateOf(mutableListOf(
                                User(pfpId = R.drawable.messipelado),
                                User(name = "John", pfpId = R.drawable.bichopelado)
                            )),
                            mapPic =
                            mutableIntStateOf(R.drawable.map_placehhoder)

                        )
                    )
                }


                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    OurNavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        startDestination = "Login",
                        composables = mutableMapOf(
                            "Login" to
                                    @Composable{
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
                            },
                            "Home" to {
                                val openAlertDialog = remember { mutableStateOf(false) }
                                ConfirmationDialog(
                                    onConfirmation = {
                                        password.value = ""
                                        navController.navigate("Login")
                                    },
                                    openAlertDialog = openAlertDialog
                                )
                                HomeScreen(
                                    activeUserState = currentUser,
                                    onLogoutClick = {
                                        openAlertDialog.value = true
                                    },
                                    onProfileNameClick = {
                                        navController.navigate("Profile")
                                    },
                                    activity = activity
                                )
                            },
                            "Profile" to {
                                ProfileInfoScreen(
                                    user = currentUser,
                                    onReturnPress = { navController.navigate("Home") }
                                )
                            }
                        )
                    )

                }
            }
        }
    }
}