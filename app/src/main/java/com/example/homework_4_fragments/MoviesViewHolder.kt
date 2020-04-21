package com.example.homework_4_fragments

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MoviesViewHolder (itemItem: View): RecyclerView.ViewHolder(itemItem){

    var movieImg: ImageView = itemItem.findViewById(R.id.imgMovie)
    var movieTitleTxt: TextView = itemItem.findViewById(R.id.titleMovie)
    var movieDescriptionTxt: TextView = itemItem.findViewById(R.id.descriptionMovie)


    fun bind(item: RecyclerMoviesItem) {
        movieImg.setImageResource(item.image)
        movieTitleTxt.text = item.title
        movieDescriptionTxt.text = item.description
    }
}

