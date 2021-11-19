package com.example.ecothon.response

data class LoginResponse(
    val token: String,
    val user: User
)
data class User(
    val __v: Int,
    val _id: String,
    val email: String,
    val name: String,
    val username: String
)