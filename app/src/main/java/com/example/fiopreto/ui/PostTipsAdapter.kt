package com.example.fiopreto.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fiopreto.PostTips
import com.example.fiopreto.R

class PostTipsAdapter(
    private val callback: (PostTips) -> Unit
) : RecyclerView.Adapter<PostTipsAdapter.PostsTipsViewHolder>() {

    private var postTips: List<PostTips> = emptyList()
    /*private lateinit var uploadButton: MaterialButton
    private var selectedImage: Uri? = null*/

    inner class PostsTipsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(postTips: PostTips) {
            itemView.findViewById<AppCompatTextView>(R.id.personNameTips).text =
                postTips.userTips?.name
            itemView.findViewById<AppCompatTextView>(R.id.personTcxtTips).text =
                postTips.text
            val imageView = itemView.findViewById<AppCompatImageView>(R.id.imageTips)
            itemView.setOnClickListener { callback.invoke(postTips) }

            Glide
                .with(itemView)
                .load(postTips.pathImageTips)
                .placeholder(R.drawable.logo)
                .into(imageView);
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostsTipsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post_tips, parent, false)
        return PostsTipsViewHolder(view)
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

    override fun onBindViewHolder(holder: PostsTipsViewHolder, position: Int) {
        holder.bind(postTips[position])
    }

    override fun getItemCount(): Int {
        return  postTips.size
    }

    fun setItems(list: List<PostTips>){
        postTips = list
        notifyDataSetChanged()
    }

}

