package com.example.fiopreto.ui

import com.example.fiopreto.PostSalon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fiopreto.R

class SalonAdapter(
    private val callback: (PostSalon) -> Unit
) : RecyclerView.Adapter<SalonAdapter.SaloonViewHolder>() {

    private var postSalon: List<PostSalon> = emptyList()

    inner class SaloonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(postSalon: PostSalon) {
            itemView.findViewById<AppCompatTextView>(R.id.salonName).text =
                postSalon.name
            /*itemView.findViewById<AppCompatTextView>(R.id.salonAddress).text =
                postSalon.address?.street*/
            itemView.findViewById<AppCompatTextView>(R.id.salonState).text =
                postSalon.site
            val imageView = itemView.findViewById<AppCompatImageView>(R.id.imageSalon)
            itemView.setOnClickListener { callback.invoke(postSalon) }

            Glide
                .with(itemView)
                .load(postSalon.pathImage)
                .placeholder(R.drawable.logo)
                .into(imageView);
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SaloonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_salon, parent, false)
        return SaloonViewHolder(view)
    }

    override fun onBindViewHolder(holder: SaloonViewHolder, position: Int) {
        holder.bind(postSalon[position])
    }

    override fun getItemCount(): Int {
        return postSalon.size
    }

    fun setItems(list: List<PostSalon>) {
        postSalon = list
        notifyDataSetChanged()
    }

}
