package com.carlyadam.kotlin.di

import com.carlyadam.kotlin.data.api.model.ApiService
import com.carlyadam.kotlin.data.db.AppDatabase
import com.carlyadam.kotlin.repository.PersonRepository
import com.carlyadam.kotlin.utilities.NetworkConnectionInterceptor
import com.carlyadam.kotlin.viewmodel.PersonViewModel
import com.carlyadam.kotlin.viewmodel.PersonViewModelFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
object AppModule {
    // just declare it
    val myModule = module {
        single { ApiService(get()) }
        single { NetworkConnectionInterceptor(get()) }
        single { PersonRepository(get(),get()) }
        single { PersonViewModelFactory(get()) }
        single { AppDatabase(get()) }
        viewModel { PersonViewModel(get()) }

    }

}