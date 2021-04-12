package com.hasan.coroutineswithretrofit.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hasan.coroutineswithretrofit.models.Post
import com.hasan.coroutineswithretrofit.repositories.PostRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class PostViewModel :ViewModel() {


    private val postRepository = PostRepository()
    fun getPosts(): LiveData<List<Post>>{
        return postRepository.getPosts()
    }
/*    val postMutableLiveData : MutableLiveData<List<Post>> = MutableLiveData()

    fun getPosts(){
        viewModelScope.launch {
            try {
                val response = postRepository.getPosts()
                postMutableLiveData.value = response
            }catch (e:Exception){
                Log.d("PostViewModel", "getPosts: ${e.localizedMessage}")
            }

        }
    }*/
}