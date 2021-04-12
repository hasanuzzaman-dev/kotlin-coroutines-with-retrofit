package com.hasan.coroutineswithretrofit.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hasan.coroutineswithretrofit.models.Post
import com.hasan.coroutineswithretrofit.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepository {

    companion object{
        private const val TAG = "PostRepository"
    }
    lateinit var postMutableLiveData: MutableLiveData<List<Post>>

      fun getPosts(): LiveData<List<Post>> {

        postMutableLiveData = MutableLiveData()

        getAllPost()

        return postMutableLiveData
    }

      private fun getAllPost() {
        val postCall = RetrofitInstance.apiInterface.getAllPost()
        postCall.enqueue(object : Callback<List<Post>?> {
            override fun onResponse(call: Call<List<Post>?>, response: Response<List<Post>?>) {
                if (response.code() == 200) {
                    postMutableLiveData.value = response.body()
                } else {
                    Log.d(TAG, "onResponse: ${response.code()}")
                    postMutableLiveData.value = null
                }
            }

            override fun onFailure(call: Call<List<Post>?>, t: Throwable) {
                Log.d(TAG, "onFailure: " + t.localizedMessage)
                postMutableLiveData.value = null
            }
        })
    }

    //suspend fun getPosts():List<Post> = RetrofitInstance.apiInterface.getAllPost()
}