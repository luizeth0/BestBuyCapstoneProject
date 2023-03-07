package com.capstoneproject.bestbuy.model.stores


import com.google.gson.annotations.SerializedName

data class Service(
    @SerializedName("service")
    val service: String? = null
)