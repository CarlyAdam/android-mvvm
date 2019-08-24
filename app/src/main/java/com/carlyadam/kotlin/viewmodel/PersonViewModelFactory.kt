package com.carlyadam.kotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.carlyadam.kotlin.repository.PersonRepository



@Suppress("UNCHECKED_CAST")
class PersonViewModelFactory(
    private val repository: PersonRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PersonViewModel(repository) as T
    }
}
