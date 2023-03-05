package com.capstoneproject.bestbuy.model.products


import com.google.gson.annotations.SerializedName

data class CategoryPath(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null
)