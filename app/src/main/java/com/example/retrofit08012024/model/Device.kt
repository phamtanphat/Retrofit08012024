package com.example.retrofit08012024.model

import com.google.gson.annotations.SerializedName

data class Device(
    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("createdAt") var createdAt: String? = null,
    @SerializedName("data") var data: Data? = null
)

data class Data(
    @SerializedName("year") var year: Int? = null,
    @SerializedName("price") var price: Double? = null,
    @SerializedName("CPU model") var cpuModel: String? = null,
    @SerializedName("Hard disk size") var hardDiskSize: String? = null
)