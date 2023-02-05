package com.example.senanov.domain.POJO

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName


data class Country (
    @SerializedName("country")
    val country: String

)
