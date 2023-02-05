package com.example.senanov.presentation.activity.recycler

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.senanov.domain.POJO.Film
import com.example.senanovv2.databinding.CardItemBinding
import java.util.*

class AdapterFilms : ListAdapter<Film, AdapterFilms.FilmViewHolder>(FilmDiffCallback()) {

    inner class FilmViewHolder(val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val binding = CardItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FilmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = getItem(position)
        val binding = holder.binding

        Glide.with(holder.itemView.context).load(film.posterURL).into(binding.imageViewPoster)

        val genre = film.genres.map { it.genre }[FIRST_GENRE].replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(
                Locale.getDefault()
            ) else it.toString()
        }
        val year = film.year

        binding.textViewCategory.text = String.format("%s (%s)", genre, year)
        binding.textViewName.text = film.nameRu

        if (film.favourite) {
            binding.imageViewStar.visibility = View.VISIBLE
        }else{
            binding.imageViewStar.visibility = View.INVISIBLE
        }

        if (itemCount-5 <= position){
              bridge.end()
            Log.d("lesson", "reachEnd ")
        }

    }

    interface OnReachEnd{
        fun end()
    }
    lateinit var bridge:OnReachEnd

    companion object {
        const val FIRST_GENRE = 0
    }
}
