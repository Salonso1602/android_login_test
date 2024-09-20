package com.example.demo23082024.entities

import com.example.demo23082024.R

data class User (
    val name : String = "Jane",
    val lastname : String = "Doe",
    val pfpId : Int = R.drawable.ic_launcher_background,
    val email : String = "email",
    val password : String = "pass"
)