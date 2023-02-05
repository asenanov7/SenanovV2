package com.example.senanov.data.network

import com.example.senanov.domain.POJO.DetailInfo
import com.example.senanov.domain.POJO.Response
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @Headers("accept: application/json", "X-API-KEY: 642e0a91-8df7-48fc-a932-b8b4ebacf452")
    @GET("api/v2.2/films/top?type=TOP_100_POPULAR_FILMS")
    fun getTopFilms(@Query("page")page: Int): Single<Response>

    @Headers("accept: application/json", "X-API-KEY: 642e0a91-8df7-48fc-a932-b8b4ebacf452")
    @GET("api/v2.2/films/{id}")
    fun getDetailInfo(@Path("id") id: Int): Single<DetailInfo>

    @Headers("accept: application/json", "X-API-KEY: 642e0a91-8df7-48fc-a932-b8b4ebacf452")
    @GET("api/v2.1/films/search-by-keyword")
    fun searchAndGetFilms(@Query("keyword") keyword: String, @Query("page") page:Int): Single<Response>

}