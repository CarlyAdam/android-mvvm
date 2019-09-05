package com.carlyadam.kotlin.viewmodel

import androidx.lifecycle.ViewModel
import com.carlyadam.kotlin.repository.PersonRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.carlyadam.kotlin.data.db.Person

class PersonViewModel(
  var personRepository: PersonRepository
) : ViewModel() {

  lateinit var  person : LiveData<List<Person>>

    suspend fun getPerson(): LiveData<List<Person>> {
        person = personRepository.getPersons()
        return person
    }



}


