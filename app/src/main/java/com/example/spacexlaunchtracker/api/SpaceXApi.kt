package com.example.spacexlaunchtracker.api

import com.example.spacexlaunchtracker.model.Launch
import retrofit2.Call
import retrofit2.http.GET

interface SpaceXApi {
    @GET("launches")
    fun getLaunches(): Call<List<Launch>>
}


