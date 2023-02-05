package com.example.senanov.domain.POJO


import com.google.gson.annotations.SerializedName


data class Response (

    @SerializedName("films")
    val films: List<Film>

)

