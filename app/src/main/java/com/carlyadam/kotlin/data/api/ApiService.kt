package com.carlyadam.kotlin.data.api.model

import com.carlyadam.kotlin.data.api.response.PersonResponse
import com.carlyadam.kotlin.utilities.Constant
import com.carlyadam.kotlin.utilities.Constant.API_URL
import com.carlyadam.kotlin.utilities.NetworkConnectionInterceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("ryu6b")
    suspend fun getPerson(): Response<PersonResponse>

    companion object {
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ): ApiService {

            val okkHttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okkHttpclient)
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }

}






