package com.carlyadam.kotlin.di

import com.carlyadam.kotlin.data.api.model.ApiService
import com.carlyadam.kotlin.data.db.AppDatabase
import com.carlyadam.kotlin.repository.PersonRepository
import com.carlyadam.kotlin.utilities.DataStore
import com.carlyadam.kotlin.utilities.NetworkConnectionInterceptor
import com.carlyadam.kotlin.viewmodel.PersonViewModelFactory
import org.koin.dsl.module
object AppModule {
    // just declare it
    val myModule = module {
        single { DataStore(get()) }
        single { ApiService(get()) }
        single { NetworkConnectionInterceptor(get()) }
        single { PersonRepository(get()) }
        single { PersonViewModelFactory(get()) }

    }

}