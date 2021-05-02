package com.example.movierecommendation.adapters

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.movierecommendation.model.Movie

abstract class MovieListBaseViewHolder(view:View) :RecyclerView.ViewHolder(view){
    abstract fun bind(context: Context,dataList:List<Movie>,pos:Int)
}