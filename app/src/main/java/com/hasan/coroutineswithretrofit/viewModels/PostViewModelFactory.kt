package com.hasan.coroutineswithretrofit.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hasan.coroutineswithretrofit.repositories.PostRepository

class PostViewModelFactory(private val postRepository: PostRepository)
   /* : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //return PostViewModel(postRepository) as T
    }

}*/