package com.example.demo23082024.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo23082024.R
import com.example.demo23082024.ui.theme.Demo23082024Theme

@Composable
fun LoginScreen(modifier: Modifier = Modifier,
                userNameState: MutableState<String>,
                passwordState: MutableState<String>,
                onLoginClick : () -> Unit,
) {
    val (passwordVisible, setPasswordVisibility) = remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .size(width = 1000.dp, height = 1000.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
            ){
                Image(
                    painter = painterResource(id = R.drawable.download),
                    contentDescription = "Login image",
                    modifier = Modifier
//                        .size(250.dp)
                        .align(Alignment.Center)
                )
                Text(
                    text = "Login",
                    modifier = Modifier
                        .padding(16.dp),
                    textAlign = TextAlign.Start,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            OutlinedTextField(
                value = userNameState.value,
                singleLine = true,
                onValueChange = { userNameState.value = it },
                label = { Text(text = "E-Mail") },
                modifier = Modifier.fillMaxWidth(0.9f)
            )
            OutlinedTextField(
                value = passwordState.value,
                singleLine = true,
                onValueChange = { passwordState.value = it },
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
                onClick = onLoginClick,
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

@Preview(showBackground = false)
@Composable
private fun LoginScreenPreview(modifier: Modifier = Modifier) {
    Demo23082024Theme {
        LoginScreen(
            userNameState = remember { mutableStateOf("") },
            passwordState = remember { mutableStateOf("") },
            onLoginClick = {}
        )
    }
}