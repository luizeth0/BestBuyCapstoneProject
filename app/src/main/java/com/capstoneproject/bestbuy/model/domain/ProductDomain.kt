package com.capstoneproject.bestbuy.model.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.capstoneproject.bestbuy.model.products.Image
import com.capstoneproject.bestbuy.model.products.Product

data class ProductDomain(
    @PrimaryKey
    val sku: Int,
    val image: String,
    val name: String,
    val type: String,
    val price: Double,
    val rating: Double,
    val reviewcount: Int,
    val plot: String,
    val addToCartUrl: String,
    val images: List<Image>

)

fun List<Product>?.mapToDomainProducts(): List<ProductDomain> =
    this?.map {
        ProductDomain(
            sku = it.sku ?: 0,
            image = it.image ?: "not available",
            name = it.name ?: "not available",
            type = it.type ?: "not available",
            price = it.salePrice ?: 0.0,
            rating = it.customerReviewAverage ?: 0.0,
            reviewcount = it.customerReviewCount ?: 0,
            plot = it.plot ?: "not available",
            addToCartUrl = it.addToCartUrl ?: "not available",
            images = it.images ?: emptyList()

        )
    } ?: emptyList()
