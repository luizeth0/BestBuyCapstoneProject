package com.capstoneproject.bestbuy.model.products


import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("active")
    val active: Boolean? = null,
    @SerializedName("activeUpdateDate")
    val activeUpdateDate: String? = null,
    @SerializedName("addToCartUrl")
    val addToCartUrl: String? = null,
    @SerializedName("albumTitle")
    val albumTitle: String? = null,
    @SerializedName("artistName")
    val artistName: Any? = null,
    @SerializedName("classId")
    val classId: Int? = null,
    @SerializedName("color")
    val color: String? = null,
    @SerializedName("condition")
    val condition: String? = null,
    @SerializedName("customerReviewAverage")
    val customerReviewAverage: Double? = null,
    @SerializedName("customerReviewCount")
    val customerReviewCount: Int? = null,
    @SerializedName("customerTopRated")
    val customerTopRated: Boolean? = null,
    @SerializedName("department")
    val department: String? = null,
    @SerializedName("departmentId")
    val departmentId: Int? = null,
    @SerializedName("description")
    val description: Any? = null,
    @SerializedName("digital")
    val digital: Boolean? = null,
    @SerializedName("esrbRating")
    val esrbRating: Any? = null,
    @SerializedName("format")
    val format: String? = null,
    @SerializedName("fulfilledBy")
    val fulfilledBy: Any? = null,
    @SerializedName("genre")
    val genre: String? = null,
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("images")
    val images: List<Image>? = null,
    @SerializedName("inStoreAvailability")
    val inStoreAvailability: Boolean? = null,
    @SerializedName("inStoreAvailabilityText")
    val inStoreAvailabilityText: Any? = null,
    @SerializedName("inStoreAvailabilityUpdateDate")
    val inStoreAvailabilityUpdateDate: String? = null,
    @SerializedName("inStorePickup")
    val inStorePickup: Boolean? = null,
    @SerializedName("itemUpdateDate")
    val itemUpdateDate: String? = null,
    @SerializedName("largeFrontImage")
    val largeFrontImage: String? = null,
    @SerializedName("largeImage")
    val largeImage: String? = null,
    @SerializedName("leftViewImage")
    val leftViewImage: Any? = null,
    @SerializedName("lowPriceGuarantee")
    val lowPriceGuarantee: Boolean? = null,
    @SerializedName("mediumImage")
    val mediumImage: String? = null,
    @SerializedName("minutePrice")
    val minutePrice: String? = null,
    @SerializedName("mobileUrl")
    val mobileUrl: String? = null,
    @SerializedName("modelNumber")
    val modelNumber: String? = null,
    @SerializedName("mpaaRating")
    val mpaaRating: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("onlineAvailability")
    val onlineAvailability: Boolean? = null,
    @SerializedName("onlineAvailabilityText")
    val onlineAvailabilityText: Any? = null,
    @SerializedName("onlineAvailabilityUpdateDate")
    val onlineAvailabilityUpdateDate: String? = null,
    @SerializedName("orderable")
    val orderable: String? = null,
    @SerializedName("originalReleaseDate")
    val originalReleaseDate: Any? = null,
    @SerializedName("plot")
    val plot: String? = null,
    @SerializedName("priceUpdateDate")
    val priceUpdateDate: String? = null,
    @SerializedName("productTemplate")
    val productTemplate: String? = null,
    @SerializedName("quantityLimit")
    val quantityLimit: Int? = null,
    @SerializedName("regularPrice")
    val regularPrice: Double? = null,
    @SerializedName("releaseDate")
    val releaseDate: String? = null,
    @SerializedName("rightViewImage")
    val rightViewImage: Any? = null,
    @SerializedName("salePrice")
    val salePrice: Double? = null,
    @SerializedName("screenFormat")
    val screenFormat: String? = null,
    @SerializedName("shippingCost")
    val shippingCost: Any? = null,
    @SerializedName("sku")
    val sku: Int? = null,
    @SerializedName("startDate")
    val startDate: String? = null,
    @SerializedName("studio")
    val studio: String? = null,
    @SerializedName("subclass")
    val subclass: String? = null,
    @SerializedName("subclassId")
    val subclassId: Int? = null,
    @SerializedName("thumbnailImage")
    val thumbnailImage: String? = null,
    @SerializedName("topViewImage")
    val topViewImage: Any? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("weight")
    val weight: String? = null
)