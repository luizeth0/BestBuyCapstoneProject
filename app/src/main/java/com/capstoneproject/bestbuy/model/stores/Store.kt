package com.capstoneproject.bestbuy.model.stores


import com.google.gson.annotations.SerializedName

data class Store(
    @SerializedName("address")
    val address: String? = null,
    @SerializedName("address2")
    val address2: String? = null,
    @SerializedName("brand")
    val brand: Any? = null,
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("distance")
    val distance: Double? = null,
    @SerializedName("fullPostalCode")
    val fullPostalCode: String? = null,
    @SerializedName("gmtOffset")
    val gmtOffset: Int? = null,
    @SerializedName("hours")
    val hours: String? = null,
    @SerializedName("hoursAmPm")
    val hoursAmPm: String? = null,
    @SerializedName("language")
    val language: Any? = null,
    @SerializedName("lat")
    val lat: Double? = null,
    @SerializedName("lng")
    val lng: Double? = null,
    @SerializedName("locationType")
    val locationType: String? = null,
    @SerializedName("longName")
    val longName: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("phone")
    val phone: String? = null,
    @SerializedName("postalCode")
    val postalCode: String? = null,
    @SerializedName("region")
    val region: String? = null,
    @SerializedName("services")
    val services: List<Service?>? = null,
    @SerializedName("storeId")
    val storeId: Int? = null,
    @SerializedName("storeType")
    val storeType: String? = null,
    @SerializedName("tradeIn")
    val tradeIn: Any? = null
)