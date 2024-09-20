package com.example.demo23082024.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.res.painterResource
import com.example.demo23082024.R
import com.example.demo23082024.entities.JoinableActivity

@Composable
fun ActivityMap(
    activity: MutableState<JoinableActivity>
) {
    // in the future this can use the activity location to create the appropiate map component
    Image(
        painter = painterResource(id = activity.value.mapPic.intValue),
        contentDescription = "Map to activity"
    )
}