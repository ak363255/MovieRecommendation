package com.example.movierecommendation.fragments

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movierecommendation.R
import com.example.movierecommendation.adapters.MovieListAdapter
import com.example.movierecommendation.model.Movie
import kotlinx.android.synthetic.main.fragment_movie_list.*

class MovieListFragment:Fragment(R.layout.fragment_movie_list) {
    var movieAdapter:MovieListAdapter? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
    }

    private fun setUpAdapter() {
        movieAdapter = MovieListAdapter()
        movie_list_rv.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        movie_list_rv.adapter = movieAdapter
        movieAdapter?.submitList(createDummyData())
        movieAdapter?.notifyDataSetChanged()
    }

    private fun createDummyData():List<Movie>{
        val des = "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe"
        var data:List<Movie> = listOf(Movie(description = des),Movie(description = des),Movie(description = des),Movie(description = des),Movie(description = des))
        return data
    }

    companion object{
        fun getNewInstance() = MovieListFragment()
    }
}