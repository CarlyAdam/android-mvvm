package com.carlyadam.kotlin.utilities

import android.content.Context
import android.widget.Toast

class DataStore(private val context: Context){
    fun displayToast(){
        Toast.makeText(context,"Hello",Toast.LENGTH_SHORT).show()
    }
}