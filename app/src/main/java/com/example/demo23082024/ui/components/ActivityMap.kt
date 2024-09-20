package com.example.demo23082024.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.demo23082024.R

@Composable
fun ActivityMap() {
    Image(
        painter = painterResource(id = R.drawable.map_placehhoder),
        contentDescription = "Map to activity"
    )
}