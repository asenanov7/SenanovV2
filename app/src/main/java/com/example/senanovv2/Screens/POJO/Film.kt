package com.example.senanov.domain.POJO

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.senanovv2.Screens.database.CountryTypeConverter
import com.example.senanovv2.Screens.database.GenreTypeConverter
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

@Entity(tableName = "films")
@TypeConverters(GenreTypeConverter::class, CountryTypeConverter::class)
data class Film(

    @PrimaryKey(autoGenerate = false)
    @SerializedName("filmId")
    val filmID: Long,

    @SerializedName("nameRu")
    val nameRu: String,

    @SerializedName("year")
    val year: String,

    @SerializedName("genres")
    val genres: List<Genre>,

    @SerializedName("countries")
    val countries: List<Country>,

    @SerializedName("posterUrl")
    val posterURL: String,

    @SerializedName("ratingVoteCount")
    val ratingVoteCount:Long,

    val favourite:Boolean


    )
