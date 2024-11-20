package com.example.retrofit08012024

import com.example.retrofit08012024.model.Device
import com.example.retrofit08012024.model.Phone
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

@JvmSuppressWildcards
interface ApiService {

    @GET("objects")
    fun fetchListPhone(): Call<List<Phone>>

    @POST("objects")
    fun addNewPhone(@Body requestBody: RequestBody): Call<Device>

}