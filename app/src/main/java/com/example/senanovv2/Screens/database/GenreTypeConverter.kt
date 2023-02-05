package com.example.senanovv2.Screens.database

import androidx.room.TypeConverter
import com.example.senanov.domain.POJO.Genre
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenreTypeConverter {
    @TypeConverter
    fun fromCountries(countries: List<Genre>?): String? {
        return countries?.let {
            val gson = Gson()
            gson.toJson(it)
        }
    }

    @TypeConverter
    fun toCountries(data: String?): List<Genre>? {
        return data?.let {
            val gson = Gson()
            val type = object : TypeToken<List<Genre>>() {}.type
            gson.fromJson(it, type)
        }
    }
}