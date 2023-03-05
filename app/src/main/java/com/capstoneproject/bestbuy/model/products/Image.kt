package com.capstoneproject.bestbuy.model.products


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("href")
    val href: String? = null,
    @SerializedName("primary")
    val primary: Boolean? = null,
    @SerializedName("rel")
    val rel: String? = null,
    @SerializedName("unitOfMeasure")
    val unitOfMeasure: String? = null,
    @SerializedName("width")
    val width: String? = null
)