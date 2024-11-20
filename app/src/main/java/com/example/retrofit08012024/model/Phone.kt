package com.example.retrofit08012024.model

data class Phone (
    var id: String? = null,
    var name: String? = null,
    var data: Configuration? = null,
)

data class Configuration(
    var color: String? = null,
    var capacity: String? = null
)