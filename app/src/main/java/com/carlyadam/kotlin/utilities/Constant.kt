package com.carlyadam.kotlin.utilities

import kotlinx.coroutines.*
import java.io.IOException

object Constant {
    //val API_URL = "https://api.myjson.com/bins/"
    const val API_URL = "http://192.168.1.110/api/"
    const val CONEXION_ERROR = "Conexion problem"
    const val DATABASE_NAME = "app-db"
}
class NoInternetException(message: String) : IOException(message)

