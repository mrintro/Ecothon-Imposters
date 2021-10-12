package com.example.ecothon.response

data class User(
    val access_token: String,
    val created_at: String,
    val email: String,
    val id: Int,
    val name: String,
    val user_name: String
)
