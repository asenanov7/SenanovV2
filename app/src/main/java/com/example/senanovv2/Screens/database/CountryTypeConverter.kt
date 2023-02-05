package com.example.senanovv2.Screens.database

import androidx.room.TypeConverter
import com.example.senanov.domain.POJO.Country
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CountryTypeConverter {
    @TypeConverter
    fun fromCountries(countries: List<Country>?): String? {
        return countries?.let {
            val gson = Gson()
            gson.toJson(it)
        }
    }

    @TypeConverter
    fun toCountries(data: String?): List<Country>? {
        return data?.let {
            val gson = Gson()
            val type = object : TypeToken<List<Country>>() {}.type
            gson.fromJson(it, type)
        }
    }
}