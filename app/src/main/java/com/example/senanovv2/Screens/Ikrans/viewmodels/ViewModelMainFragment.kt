package com.example.senanovv2.Screens.Ikrans.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.senanov.data.database.AppDatabase
import com.example.senanov.data.network.ApiFactory
import com.example.senanov.domain.POJO.Film
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.TreeSet

class ViewModelMainFragment():ViewModel() {


    private val compositeDisposable = CompositeDisposable()

    fun getDataFromDbLD(application: Application) =AppDatabase.getInstance(application).filmsDao().getFilmsFromDB()

    var page = 1

    val films = sortedSetOf<Film>({ p0, p1 -> p0.ratingVoteCount.compareTo(p1.ratingVoteCount) })

    fun saveToTreeSet(list:List<Film>):TreeSet<Film>{
        for (item in list){
            films.add(item)
        }
        return films
    }

    fun loadData(application: Application) {
        val disposable1  = ApiFactory.getApiService().getTopFilms(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {  page++
                   AppDatabase.getInstance(application).filmsDao()
                        .saveFilmsOnDB(saveToTreeSet(it.films).toList())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ Log.d("lesson", "saveFilmsOnDB success ${it.films}") },
                            { Log.d("lesson", "saveFilmsOnDB fail") })
                },
                { Log.d("lesson", "Failure: ${it.message}") }
            )
        compositeDisposable.add(disposable1)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }


}