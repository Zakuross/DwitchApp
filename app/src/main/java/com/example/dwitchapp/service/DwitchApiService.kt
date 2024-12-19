package com.example.dwitchapp.service

import com.example.dwitchapp.model.OrderResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import java.util.Date

interface ApiService {
    @GET("orders?populate=*")
    suspend fun getOrders(
        @Header("Authorization") token: String
    ): OrderResponse
}
object ApiClient {
    private val moshi = Moshi.Builder()
        .add(Date::class.java, Rfc3339DateJsonAdapter())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dwitch.pickle-forge.app/api/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}