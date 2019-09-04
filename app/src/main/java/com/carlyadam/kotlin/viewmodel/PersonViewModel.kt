package com.carlyadam.kotlin.viewmodel

import androidx.lifecycle.ViewModel
import com.carlyadam.kotlin.repository.PersonRepository
import androidx.lifecycle.LiveData
import com.carlyadam.kotlin.data.db.Person

class PersonViewModel(
  var personRepository: PersonRepository
) : ViewModel() {
    suspend fun getPerson(): LiveData<List<Person>> {
        return personRepository.getPersons()
    }

}


