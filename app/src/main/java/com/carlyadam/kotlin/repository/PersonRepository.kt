package com.carlyadam.kotlin.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.carlyadam.kotlin.data.api.model.ApiService
import com.carlyadam.kotlin.data.db.AppDatabase
import com.carlyadam.kotlin.data.db.Person
import com.carlyadam.kotlin.utilities.Coroutines
import com.carlyadam.kotlin.viewmodel.PersonViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject

/**
 * Repository module for handling data operations.
 */
class PersonRepository(
    private val api: ApiService,
    private val db: AppDatabase

) {


    private val personList = ArrayList<Person>()

    suspend fun getPersons(): LiveData<List<Person>> {
        return withContext(Dispatchers.IO) {
            fetchPersons()
            db.personDao().getPersons()
        }
    }

     private suspend fun fetchPersons() {
        try {
            val response = api.getPerson()
            if (response.isSuccessful) {
                personList.addAll(response.body()!!.persons!!)
                saveQuotes(personList)
            } else {
                Log.i("ERRRRRor", response.message())
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

     private fun saveQuotes(persons: List<Person>) {
        Coroutines.io {
            db.personDao().insertAll(persons)
        }
    }

}
