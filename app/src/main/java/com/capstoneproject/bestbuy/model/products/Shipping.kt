package com.capstoneproject.bestbuy.model.products


import com.google.gson.annotations.SerializedName

data class Shipping(
    @SerializedName("ground")
    val ground: Double? = null,
    @SerializedName("nextDay")
    val nextDay: Double? = null,
    @SerializedName("secondDay")
    val secondDay: Double? = null,
    @SerializedName("vendorDelivery")
    val vendorDelivery: String? = null
)