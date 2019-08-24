package com.carlyadam.kotlin

import android.app.Application
import com.carlyadam.kotlin.data.api.model.ApiService
import com.carlyadam.kotlin.di.AppModule
import com.carlyadam.kotlin.repository.PersonRepository
import com.carlyadam.kotlin.utilities.NetworkConnectionInterceptor
import com.carlyadam.kotlin.viewmodel.PersonViewModelFactory
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Android context
            androidContext(this@MyApplication)
            // modules
            modules(AppModule.myModule)
        }
    }


}