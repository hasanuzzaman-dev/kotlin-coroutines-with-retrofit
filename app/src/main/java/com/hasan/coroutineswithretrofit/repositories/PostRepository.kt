package com.hasan.coroutineswithretrofit.repositories

import com.hasan.coroutineswithretrofit.models.Post
import com.hasan.coroutineswithretrofit.retrofit.RetrofitInstance

class PostRepository {

    suspend fun getPosts():List<Post> = RetrofitInstance.apiInterface.getAllPost()
}