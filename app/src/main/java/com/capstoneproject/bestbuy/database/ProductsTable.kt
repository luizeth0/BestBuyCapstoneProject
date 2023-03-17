package com.capstoneproject.bestbuy.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.capstoneproject.bestbuy.model.domain.ProductDomain

@Entity(tableName = "products")
data class ProductTable(
    @PrimaryKey
    val sku: Int = 0,
    val image: String = "",
    val name: String = "",
    val type: String = "",
    val price: Double = 0.0,
    val rating: Double = 0.0,
    val reviewcount: Int = 0,
    val plot: String = "",
    val addToCartUrl: String = ""
)

fun ProductDomain.toDomainTable(): ProductTable {
    return ProductTable(
        this.sku,
        this.image,
        this.name,
        this.type,
        this.price,
        this.rating,
        this.reviewcount,
        this.plot,
        this.addToCartUrl
    )
}