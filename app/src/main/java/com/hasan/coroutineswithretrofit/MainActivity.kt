package com.hasan.coroutineswithretrofit

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hasan.coroutineswithretrofit.adapters.PostAdapter
import com.hasan.coroutineswithretrofit.databinding.ActivityMainBinding
import com.hasan.coroutineswithretrofit.models.Post
import com.hasan.coroutineswithretrofit.repositories.PostRepository
import com.hasan.coroutineswithretrofit.viewModels.PostViewModel
import com.hasan.coroutineswithretrofit.viewModels.PostViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var postAdapter: PostAdapter
    private lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

        val postRepository = PostRepository()
        val viewModelFactory = PostViewModelFactory(postRepository)
        postViewModel = ViewModelProvider(this,viewModelFactory)[PostViewModel::class.java]
        postViewModel.getPosts()

        postViewModel.postMutableLiveData.observe(this, Observer {
            postAdapter.setPostData(it as ArrayList<Post>)
            binding.progressbar.visibility = View.GONE

        })
    }

    private fun initRecyclerView() {

        binding.progressbar.visibility = View.VISIBLE
        postAdapter = PostAdapter(this, ArrayList())
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }
    }
}