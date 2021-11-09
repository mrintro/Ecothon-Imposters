package com.example.ecothon.response

data class LoginResponse(
    val displayName: String,
    val email: String,
    val expiresIn: String,
    val idToken: String,
    val localId: String,
    val refreshToken: String,
    val registered: Boolean
)