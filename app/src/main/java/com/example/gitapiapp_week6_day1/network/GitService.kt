package com.example.gitapiapp_week6_day1.network

import com.example.gitapiapp_week6_day1.model.Repository
import retrofit2.Call
import retrofit2.http.*

interface GitService {

//    @Headers("api_key: ")
    @GET("users/{username}/{dataRequest}")
    fun getUsers(@Path("username") userName: String,
                 @Path("dataRequest") dataRequest: String) : Call<List<Repository>>


}