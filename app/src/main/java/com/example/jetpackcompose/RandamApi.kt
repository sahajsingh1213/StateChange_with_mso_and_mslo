package com.example.jetpackcompose

import com.example.jetpackcompose.ui.theme.DataClass.User
import retrofit2.Response
import retrofit2.http.GET

interface RandamApi {

    @GET("api")
    suspend fun getMyData() : Response<User>

}