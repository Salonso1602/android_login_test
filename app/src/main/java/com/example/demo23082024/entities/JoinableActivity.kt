package com.example.demo23082024.entities

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import java.time.LocalDateTime

data class JoinableActivity
    (
            val name : String,
            val date : LocalDateTime,
            val joinedMembers : MutableState<MutableList<User>>,
            val longDescription : String,
            val shortDescription : String,
            val location : String, // in the future it can be a more applicable location type
            val mapPic : MutableIntState
            // ^^^^ this can be removed in place of using an actual map component
            // once a real location type is used,
)