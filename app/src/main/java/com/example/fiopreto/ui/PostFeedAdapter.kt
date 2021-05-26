package com.example.fiopreto.ui

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fiopreto.PostFeed
import com.example.fiopreto.R
import com.google.android.material.button.MaterialButton

class PostFeedAdapter(
    private val callback: (PostFeed) -> Unit
    ) : RecyclerView.Adapter<PostFeedAdapter.PostsFeedViewHolder>() {

    private var postsFeed: List<PostFeed> = emptyList()
    /*private lateinit var uploadButton: MaterialButton
    private var selectedImage: Uri? = null*/

    inner class PostsFeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(postFeed: PostFeed) {
            val imageView = itemView.findViewById<AppCompatImageView>(R.id.image_feed)
            itemView.setOnClickListener { callback.invoke(postFeed) }

            Glide
                .with(itemView)
                .load(postFeed.pathImage)
                .placeholder(R.drawable.logo)
                .into(imageView);
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostsFeedViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post_feed, parent, false)
        return PostsFeedViewHolder(view)
       /*
        uploadButton = view.findViewById(R.id.buttonFeed)

        uploadButton.setOnClickListener{
            uploadImage()
        }*/
    }
    /*
    private fun uploadImage(){
        if(selectedImage == null){
            val layoutFeed = R.id.layout_feed
            layoutFeed.snackbar
        }
    }*/

    override fun onBindViewHolder(holder: PostsFeedViewHolder, position: Int) {
        holder.bind(postsFeed[position])
    }

    override fun getItemCount(): Int {
        return  postsFeed.size
    }

    fun setItems(list: List<PostFeed>){
        postsFeed = list
        notifyDataSetChanged()
    }

}
