package com.capstoneproject.bestbuy.model.products


import com.google.gson.annotations.SerializedName

data class ProductVariation(
    @SerializedName("sku")
    val sku: String? = null,
    @SerializedName("variations")
    val variations: List<Variation?>? = null
)