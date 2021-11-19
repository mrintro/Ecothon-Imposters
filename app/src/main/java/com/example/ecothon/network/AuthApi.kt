package com.example.ecothon.network

import com.example.ecothon.response.LoginResponse
import com.example.ecothon.response.SignUpMessage
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {

    @FormUrlEncoded
    @POST("auth/signin")
    suspend fun loginWithEmail(
        @Field("email") email:String,
        @Field("password") password:String
    ) : LoginResponse

    @FormUrlEncoded
    @POST("auth/signup")
    suspend fun signUp(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("username") username: String,
        @Field("name") name: String
    ) : SignUpMessage
}