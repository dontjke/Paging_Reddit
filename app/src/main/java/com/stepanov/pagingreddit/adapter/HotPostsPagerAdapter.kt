package com.stepanov.pagingreddit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.stepanov.pagingreddit.adapter.HotPostsPagerAdapter.MyViewHolder
import com.stepanov.pagingreddit.databinding.HotPostItemBinding
import com.stepanov.pagingreddit.repository.HotPost

class HotPostsPagerAdapter : PagingDataAdapter<HotPost, MyViewHolder>(diffCallback) {

    inner class MyViewHolder(val binding: HotPostItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<HotPost>() {
            override fun areItemsTheSame(oldItem: HotPost, newItem: HotPost): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: HotPost, newItem: HotPost): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.binding.apply {
            titleTextView.text = currentItem?.title
            numCommentsTextView.text = currentItem?.numComments.toString()
            scoreTextView.text = currentItem?.score.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            HotPostItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}