package com.example.ecothon.repository

import com.example.ecothon.network.AuthApi

class AuthRepository(
    private val api: AuthApi
) : BaseRepository() {

    suspend fun loginWithEmail (
        email: String,
        password: String
    ) = safeApiCall {
        api.loginWithEmail(email, password)
    }

}