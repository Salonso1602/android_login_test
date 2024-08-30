package com.example.demo23082024

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.demo23082024.ui.theme.Demo23082024Theme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Demo23082024Theme {
                Scaffold (Modifier.padding(16.dp)) { sth ->
                    val userName = remember { mutableStateOf("") }
                    val password = remember { mutableStateOf("") }
                    LoginCard(
                        userName = userName,
                        password = password,
                        onLogInPress = {
                            userName.value = ""
                            password.value = ""
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun LoginCard(userName: MutableState<String>,
              password: MutableState<String>,
              onLogInPress: ()->Unit) {
    val (passwordVisible, setPasswordVisibility) = remember { mutableStateOf(false) }
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .size(width = 1000.dp, height = 1000.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(12.dp)
        ) {
            Text(
                text = "Login",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.Start),
                textAlign = TextAlign.Start,
            )
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Login image",
                modifier = Modifier
                    .size(250.dp)
            )
            OutlinedTextField(
                value = userName.value,
                singleLine = true,
                onValueChange = { userName.value = it },
                label = { Text(text = "Username") },
                modifier = Modifier.fillMaxWidth(0.9f)
            )
            OutlinedTextField(
                value = password.value,
                singleLine = true,
                onValueChange = { password.value = it },
                label = { Text(text = "Password") },
                modifier = Modifier.fillMaxWidth(0.9f),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    // Localized description for accessibility services
                    val description = if (passwordVisible) "Hide password" else "Show password"

                    // Toggle button to hide or display password
                    IconButton(onClick = {setPasswordVisibility(!passwordVisible)}){
                        Icon(imageVector  = image, description)
                    }
                }

                )
            TextButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.End)
            ) {
                Text(text = "forgot password?")
            }
            OutlinedButton(
                onClick = onLogInPress,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
            ) {
                Text(text = "Login")
            }
            Row (
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            )
            {
                Text(text = "Don't have an account?"
                )
                TextButton(
                    onClick = { /*TODO*/ },
                ) {
                    Text(text = "Sign-Up")
                }
            }
            Text(text = "Or login with",
                modifier = Modifier
                    .padding(12.dp)
            )
            Row (
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(75.dp)
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.gmail_icon),
                        contentDescription = "Gmail logo",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(75.dp)
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.facebook_logo_social_media_computer_icons_icon_facebook_drawing),
                        contentDescription = "Facebook logo",
                    )
                }

            }

        }

    }
}