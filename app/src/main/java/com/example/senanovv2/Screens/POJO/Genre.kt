package com.example.senanov.domain.POJO

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName


data class Genre (
    @SerializedName("genre")
    val genre: String

)