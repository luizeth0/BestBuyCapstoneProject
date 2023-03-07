package com.capstoneproject.bestbuy.model.stores


import com.google.gson.annotations.SerializedName

data class StoresResponse(
    @SerializedName("canonicalUrl")
    val canonicalUrl: String? = null,
    @SerializedName("currentPage")
    val currentPage: Int? = null,
    @SerializedName("from")
    val from: Int? = null,
    @SerializedName("partial")
    val partial: Boolean? = null,
    @SerializedName("queryTime")
    val queryTime: String? = null,
    @SerializedName("stores")
    val stores: List<Store?>? = null,
    @SerializedName("to")
    val to: Int? = null,
    @SerializedName("total")
    val total: Int? = null,
    @SerializedName("totalPages")
    val totalPages: Int? = null,
    @SerializedName("totalTime")
    val totalTime: String? = null,
    @SerializedName("warnings")
    val warnings: String? = null
)