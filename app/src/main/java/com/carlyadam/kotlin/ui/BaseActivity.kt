package com.carlyadam.kotlin.ui

import android.annotation.SuppressLint
import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.carlyadam.kotlin.viewmodel.PersonViewModelFactory
import dmax.dialog.SpotsDialog
import org.koin.android.ext.android.inject

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity()  {

    val personViewModelFactory: PersonViewModelFactory by inject()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }
}
