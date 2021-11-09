package com.example.ecothon.network

import com.example.ecothon.response.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {

    @FormUrlEncoded
    @POST("auth/login/email")
    suspend fun loginWithEmail(
        @Field("email") email:String,
        @Field("password") password:String
    ) : LoginResponse

    @POST("auth/login/username")
    suspend fun loginWithUsername(
        @Field("username") username:String,
        @Field("password") password:String
    ) : Any
}