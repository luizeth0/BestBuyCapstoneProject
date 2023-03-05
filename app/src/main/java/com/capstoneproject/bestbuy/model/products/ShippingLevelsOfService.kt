package com.capstoneproject.bestbuy.model.products


import com.google.gson.annotations.SerializedName

data class ShippingLevelsOfService(
    @SerializedName("serviceLevelId")
    val serviceLevelId: Int? = null,
    @SerializedName("serviceLevelName")
    val serviceLevelName: String? = null,
    @SerializedName("unitShippingPrice")
    val unitShippingPrice: Double? = null
)