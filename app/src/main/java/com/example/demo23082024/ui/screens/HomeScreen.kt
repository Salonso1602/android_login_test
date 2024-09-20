package com.example.demo23082024.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo23082024.R
import com.example.demo23082024.entities.User
import com.example.demo23082024.ui.components.ActivityMap
import com.example.demo23082024.ui.components.UserListPreviewComponent
import com.example.demo23082024.ui.theme.Demo23082024Theme
import java.time.LocalDateTime

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    userNameState: MutableState<String>,
    onLogoutClick: () -> Unit
){
    Column {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.55f)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(red = 243, green = 159, blue = 57),
                            Color(red = 237, green = 120, blue = 47),
                        )
                    )
                ),
        ) {
            Column {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    IconButton(
                        onClick = onLogoutClick,
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBackIosNew,
                            contentDescription = "Logout",
                            tint = Color.White
                        )
                    }
                    TextButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Text(
                            text = "Hello " + userNameState.value,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.White
                        )
                    }
                    IconButton(
                        onClick = { /*TODO*/ },

                        ) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Logout",
                            tint = Color.White
                        )
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .fillMaxHeight()
                    ) {
                        Column(
                            verticalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier.fillMaxHeight()
                        ) {
                            Row {
                                Column {
                                    val date = LocalDateTime.now()
                                    Text(
                                        date.dayOfMonth.toString(),
                                        fontSize = 36.sp,
                                        color = Color.White
                                    )
                                    Text(
                                        date.month.toString(),
                                        fontSize = 20.sp,
                                        color = Color.White
                                    )
                                }
                            }
                            Row {
                                Column(
                                    verticalArrangement = Arrangement.SpaceEvenly,
                                    modifier = Modifier.fillMaxHeight(0.33f)
                                ) {
                                    Text(
                                        "Cochabamba",
                                        fontSize = 24.sp,
                                        color = Color.White
                                    )
                                    Text(
                                        "Clean City",
                                        fontSize = 24.sp,
                                        color = Color.White
                                    )
                                    Text(
                                        "Together",
                                        fontSize = 24.sp,
                                        color = Color.White
                                    )
                                }
                            }
                            Row {
                                Icon(
                                    imageVector = Icons.Filled.LocationOn,
                                    contentDescription = "Location Icon",
                                    tint = Color.White
                                )
                                Text(
                                    "Cochabamba, BOL",
                                    fontSize = 20.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.75f)
                            .align(Alignment.Bottom)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.kiryu),
                            contentDescription = "kir",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .heightIn(max = 1200.dp)
                                .fillMaxWidth()
                        )
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            UserListPreviewComponent(
                users = remember {mutableStateOf(mutableListOf(
                    User(pfpId = R.drawable.messipelado),
                    User(name = "John", pfpId = R.drawable.bichopelado)
                ))},
                message = remember {mutableStateOf("have joined this event")}
            )
        }
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "Hi Altiplaneros, We wait you to join with us. \n" +
                        "We need you to save our city stay clean and beautiful.\n" +
                        "Let's join Altiplaneros!",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            ActivityMap()
        }
        Row(
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            OutlinedIconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth(0.20f)
                    .fillMaxHeight(),
                shape = RoundedCornerShape(16.dp),
                border =  BorderStroke(color = Color.LightGray, width = 2.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.BookmarkBorder,
                    contentDescription = "Bookmark activity",
                    modifier = Modifier.size(36.dp),
                    tint = Color.LightGray
                )
            }
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth(0.80f)
                    .fillMaxHeight(),
                colors = ButtonColors(Color.Black, Color.White, Color.DarkGray, Color.White)
            ) {
                Text(
                    text = "Join Now",
                    fontSize = 20.sp
                    )
            }
        }
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