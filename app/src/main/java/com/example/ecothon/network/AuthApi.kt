package com.example.ecothon.network

import retrofit2.http.Field

interface AuthApi {

    fun login(
        @Field("email") email:String,
        @Field("password") password:String
    ) : Any

}