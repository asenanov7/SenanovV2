package com.example.senanov.presentation.activity.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.senanov.domain.POJO.Film

class FilmDiffCallback: DiffUtil.ItemCallback<Film>() {
    override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean {
        return oldItem.filmID == newItem.filmID
    }

    override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean {
        return oldItem == newItem
    }
}