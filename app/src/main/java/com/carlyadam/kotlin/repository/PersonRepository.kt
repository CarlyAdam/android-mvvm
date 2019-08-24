package com.carlyadam.kotlin.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.carlyadam.kotlin.data.api.model.ApiService
import com.carlyadam.kotlin.data.api.model.PersonPojo
import com.carlyadam.kotlin.data.db.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository module for handling data operations.
 */
class PersonRepository(
    private val api: ApiService
   // private val db: AppDatabase

) {

    private val person = MutableLiveData<PersonPojo>()

     //fun getPersonsDB() = db.personDao().getPersons()

    suspend fun getPersons(): LiveData<PersonPojo> {
        return withContext(Dispatchers.IO) {
            fetchPersons()

        }
    }

    suspend fun fetchPersons(): LiveData<PersonPojo> {
        try {
            val response = api.getPerson()
            if (response.isSuccessful) {
                person.postValue(response.body()!!.person)
            } else {
                Log.i("ERRRRRor", response.message())
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return person

    }

}
