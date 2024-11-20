package com.example.retrofit08012024

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.retrofit08012024.model.Device
import com.example.retrofit08012024.model.Phone
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Request
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val apiService = RetrofitClient.getService()
//        apiService.fetchListPhone()
//            .enqueue(object : Callback<List<Phone>> {
//                override fun onResponse(p0: Call<List<Phone>>, response: Response<List<Phone>>) {
//                    Log.d("pphat", response.errorBody().toString())
////                    Log.d("pphat", response.body().toString())
//                }
//
//                override fun onFailure(p0: Call<List<Phone>>, throwable: Throwable) {
//                    Log.d("pphat", "Error ${throwable.message.toString()}")
//                }
//            })

        val requestBody = RequestBody

        val childMap = mutableMapOf<String, Any>().apply {
            put( "year", 2019)
            put( "price", 1849.99)
            put( "CPU model", "Intel Core i9")
            put( "Hard disk size", "1 TB")
        }

        val map: Map<String, Any> = mutableMapOf<String, Any>().apply {
            put("name", "Apple MacBook Pro 17")
            put("data", childMap)
        }

        val mapJson = GsonBuilder().create().toJson(map)

        apiService.addNewPhone(RequestBody.create("application/json".toMediaTypeOrNull(), mapJson))
            .enqueue(object : Callback<Device> {
                override fun onResponse(p0: Call<Device>, response: Response<Device>) {
                    Log.d("pphat", response.body().toString())
                }

                override fun onFailure(p0: Call<Device>, p1: Throwable) {
                }

            })
    }
}