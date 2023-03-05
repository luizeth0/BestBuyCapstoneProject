package com.capstoneproject.bestbuy.model.products


import com.google.gson.annotations.SerializedName

data class IncludedItem(
    @SerializedName("includedItem")
    val includedItem: String? = null
)