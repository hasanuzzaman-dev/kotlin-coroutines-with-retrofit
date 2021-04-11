package com.hasan.coroutineswithretrofit.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hasan.coroutineswithretrofit.databinding.PostItemLayoutBinding
import com.hasan.coroutineswithretrofit.models.Post

class PostAdapter(private val context: Context, private val postList: ArrayList<Post>) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PostItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /*val post = postList[position]
        holder.binding.titleTv.text = post.title
        holder.binding.descriptionTv.text = post.body*/

        //Or

        with(holder){
            with(postList[position]){
                binding.titleTv.text = this.title
                binding.descriptionTv.text = this.body
            }
        }

    }

    override fun getItemCount(): Int {
        return postList.size
    }

    inner class ViewHolder(val binding: PostItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)
}