package com.example.demo23082024.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demo23082024.entities.User
import com.example.demo23082024.ui.theme.Demo23082024Theme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileInfoScreen (
    user: MutableState<User>,
    onReturnPress : () -> Unit = {}
){
    CenterAlignedTopAppBar(
        title = {
            Text("My Profile")
        },
        navigationIcon = {
            IconButton(onClick = onReturnPress) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Go back"
                )
            }
        },
        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "Edit profile"
                )
            }
        },
    )
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.8f)
            .padding(24.dp)
    )
    {
        Image(
            painter = painterResource(id = user.value.pfpId),
            contentDescription = "Profile picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )
        TextField(
            value = "${user.value.name} ${user.value.lastname}",
            onValueChange = {},
            label = {
                Text(text = "Full Name")
            },
            enabled = false
        )
        TextField(
            value = user.value.country,
            onValueChange = {},
            label = {
                Text(text = "Country of Origin")
            },
            enabled = false
        )
        TextField(
            value = user.value.job,
            onValueChange = {},
            label = {
                Text(text = "Profession")
            },
            enabled = false
        )
        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .width(10.dp)
        )
        {
            TextField(
                value = user.value.dob.format(DateTimeFormatter.ISO_DATE),
                onValueChange = {},
                label = {
                    Text(text = "Date of Birth")
                },
                suffix = {
                    Text(text = "Age: ${user.value.dob.year - LocalDateTime.now().year}")
                },
                enabled = false
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
private fun ProfileInfoPreview(modifier: Modifier = Modifier) {
    Demo23082024Theme {
        ProfileInfoScreen(
            user = remember {
                mutableStateOf(User())
            }
        )
    }
}