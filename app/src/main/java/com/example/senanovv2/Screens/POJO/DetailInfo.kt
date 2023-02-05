package com.example.senanov.domain.POJO

import com.google.gson.annotations.SerializedName

data class DetailInfo(

@SerializedName("kinopoiskId")
val kinopoiskID: Long,

@SerializedName("nameRu")
val nameRu: String,

@SerializedName("posterUrl")
val posterURL: String,

@SerializedName("year")
val year: Long,

@SerializedName("description")
val description: String,

@SerializedName("countries")
val countries: List<Country>,

@SerializedName("genres")
val genres: List<Genre>,



)

