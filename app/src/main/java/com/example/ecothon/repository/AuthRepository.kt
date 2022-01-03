package com.example.ecothon.repository

import com.example.ecothon.network.AuthApi

class AuthRepository(
    private val api: AuthApi
) : BaseRepository() {

    suspend fun loginWithEmail (
        email: String,
        password: String
    ) = safeApiCall { api.loginWithEmail(email, password) }

    suspend fun signUp(
        email: String,
        password: String,
        username: String,
        name: String
    ) = safeApiCall {
        api.signUp(email, password, username, name)
    }

}