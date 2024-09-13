package com.example.demo23082024.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo23082024.R
import com.example.demo23082024.ui.theme.Demo23082024Theme
import java.time.LocalDateTime

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    userNameState: MutableState<String>,
    onLogoutClick: () -> Unit
){
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(red = 243, green = 159, blue = 57),
                        Color(red = 237, green = 120, blue = 47),
                    )
                )
            ),
    ){
        Column {
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ){
                IconButton(
                    onClick = onLogoutClick,
                    modifier = Modifier
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBackIosNew,
                        contentDescription = "Logout")
                }
                TextButton(
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = "Hello " + userNameState.value,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                        )
                }
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier

                ) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Logout")
                }}
            Row (
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Column (
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .fillMaxHeight(0.6f)
                ){
                    Column (
                        verticalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxHeight()
                    ){
                        Row {
                            Column {
                                val date = LocalDateTime.now()
                                Text(date.dayOfMonth.toString(),
                                    fontSize = 36.sp
                                )
                                Text(date.month.toString(),
                                    fontSize = 20.sp
                                )
                            }
                        }
                        Row {
                            Column (
                                verticalArrangement = Arrangement.SpaceEvenly,
                                modifier = Modifier.fillMaxHeight(0.33f)
                            ){
                                Text("Cochabamba",
                                    fontSize = 24.sp
                                )
                                Text("Clean City",
                                    fontSize = 24.sp
                                )
                                Text("Together",
                                    fontSize = 24.sp
                                )
                            }
                        }
                        Row {
                            Icon(imageVector = Icons.Filled.LocationOn,
                                contentDescription = "Location Icon")
                            Text("Cochabamba, BOL",
                                fontSize = 20.sp
                            )
                        }
                    }
                }
                Column (
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .align(Alignment.Bottom)
                ){
                    Image(
                        painter = painterResource(R.drawable.kiryu),
                        contentDescription = "kir",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(500.dp)

                    )
                }
            }
        }
    }
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Red)
    ){

    }
}


@Preview(showBackground = false)
@Composable
private fun HomeScreenPreview(modifier: Modifier = Modifier) {
    Demo23082024Theme {
        HomeScreen(
            userNameState = remember { mutableStateOf("Messi") },
            onLogoutClick = {}
        )
    }
}