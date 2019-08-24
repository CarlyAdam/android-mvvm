package com.carlyadam.kotlin.viewmodel

import androidx.lifecycle.ViewModel
import com.carlyadam.kotlin.data.api.model.PersonPojo
import com.carlyadam.kotlin.repository.PersonRepository
import androidx.lifecycle.LiveData

class PersonViewModel(
  var personRepository: PersonRepository
) : ViewModel() {


    suspend fun getPerson(): LiveData<List<PersonPojo>> {
        return personRepository.getPersons()
    }


}


