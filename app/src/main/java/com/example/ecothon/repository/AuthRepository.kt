package com.example.ecothon.repository

import com.google.android.gms.common.api.Api

class AuthRepository(
    private val api: Api<*>
) : BaseRepository() {

    suspend fun loginWithEmail (
        email: String,
        password: String
    ) = safeApiCall {
        api.loginWithEmail(email, password)
    }

}