package com.capstoneproject.bestbuy.model.products


import com.google.gson.annotations.SerializedName

data class Variation(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("value")
    val value: String? = null
)