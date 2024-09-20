package com.example.demo23082024.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demo23082024.entities.User
import com.example.demo23082024.ui.theme.Demo23082024Theme

@Composable
fun UserListPreviewComponent (
    users : MutableState<List<User>>,
    message : MutableState<String>
) {
    val text = "${users.value[0].name} and ${users.value.size - 1} others " +
            message.value

    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
    )
    {
        Column {
            Box(
                modifier = Modifier.padding(14.dp)
            ) {
                if(users.value.isNotEmpty())
                    Box(
                        modifier = Modifier
                            .offset((-30).dp)
                    ) {
                        Image(
                            painter = painterResource(id = users.value[0].pfpId),
                            contentDescription = "First profile picture",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                        )
                    }
                if(users.value.size > 1)
                    Box(
                        modifier = Modifier
                            .offset((-10).dp)
                    ) {
                        Image(
                            painter = painterResource(id = users.value[1].pfpId),
                            contentDescription = "Second profile picture",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                        )
                    }

                // Circle with number
                Box(
                    modifier = Modifier
                        .offset((10).dp)
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(Color.Black)
                        .align(Alignment.Center)
                ) {
                    Text(
                        text = users.value.size.toString(),
                        style = TextStyle(color = Color.White, fontSize = 12.sp),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
        Column {
            Row {
                Text(text = text)
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
private fun UserListPreview(modifier: Modifier = Modifier) {
    Demo23082024Theme {
        UserListPreviewComponent(
            users = remember {mutableStateOf(mutableListOf(
                User(),
                User(name = "John")
            ))},
            message = remember {mutableStateOf("have joined this event")}
        )
    }
}