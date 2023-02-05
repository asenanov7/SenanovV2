package com.example.senanov.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.senanov.domain.POJO.Film
import io.reactivex.rxjava3.core.Completable


@Dao
interface FilmsDao {
    @Query("SELECT * FROM films")
    fun getFilmsFromDB():LiveData<List<Film>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveFilmsOnDB(listFilms: List<Film>):Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveOnFavouriteOnDB(film: Film): Completable
}