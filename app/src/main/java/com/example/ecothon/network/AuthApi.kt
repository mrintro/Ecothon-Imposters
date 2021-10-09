package com.example.ecothon.network

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {

    @FormUrlEncoded
    @POST("auth/login/email")
    fun loginWithEmail(
        @Field("email") email:String,
        @Field("password") password:String
    ) : Any

    @POST("auth/login/username")
    fun loginWithUsername(
        @Field("username") username:String,
        @Field("password") password:String
    ) : Any
}