package com.capstoneproject.bestbuy.model.products


import com.google.gson.annotations.SerializedName

data class ProductsResponse(
    @SerializedName("canonicalUrl")
    val canonicalUrl: String? = null,
    @SerializedName("currentPage")
    val currentPage: Int? = null,
    @SerializedName("from")
    val from: Int? = null,
    @SerializedName("partial")
    val partial: Boolean? = null,
    @SerializedName("products")
    val products: List<Product>? = null,
    @SerializedName("queryTime")
    val queryTime: String? = null,
    @SerializedName("to")
    val to: Int? = null,
    @SerializedName("total")
    val total: Int? = null,
    @SerializedName("totalPages")
    val totalPages: Int? = null,
    @SerializedName("totalTime")
    val totalTime: String? = null
)