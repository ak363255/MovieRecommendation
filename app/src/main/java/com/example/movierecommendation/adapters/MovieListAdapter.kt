package com.example.movierecommendation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movierecommendation.R
import com.example.movierecommendation.model.Movie

class MovieListAdapter : RecyclerView.Adapter<MovieListBaseViewHolder>() {
    private val data: List<Movie> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListBaseViewHolder {
        var vh = MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, parent, false)
        )
        when (viewType) {
            MOVIE_VIEW_CODE -> vh = MovieViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, parent, false)
            )
        }
        return vh
    }

    override fun onBindViewHolder(holder: MovieListBaseViewHolder, position: Int) {
        holder.bind(holder.itemView.context, differ.currentList, pos = position)
    }

    override fun getItemCount(): Int = differ.currentList.size

    private val diffUtilItemCallback = object : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id.equals(newItem.id, true)
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.hashCode().equals(newItem.hashCode())
        }
    }
    private val differ = AsyncListDiffer(this, diffUtilItemCallback)

    fun submitList(list: List<Movie>) = differ.submitList(list)

    override fun getItemViewType(position: Int): Int {
        val currentData = differ.currentList[position]
        return when (currentData.viewType) {
            MOVIE_VIEW -> MOVIE_VIEW_CODE
            else -> 0
        }
    }


    companion object {
        val MOVIE_VIEW = "movie_view"
        val MOVIE_VIEW_CODE = 0
    }

}