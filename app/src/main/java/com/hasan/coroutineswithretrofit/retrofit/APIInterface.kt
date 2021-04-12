package com.hasan.coroutineswithretrofit.retrofit

import com.hasan.coroutineswithretrofit.models.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface APIInterface {

    @Headers("Content-Type:application/json")
    @GET("posts")
    fun getAllPost(): Call<List<Post>>
}