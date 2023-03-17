package com.capstoneproject.bestbuy.model.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.capstoneproject.bestbuy.model.products.Product
import com.capstoneproject.bestbuy.model.stores.Service
import com.capstoneproject.bestbuy.model.stores.Store

data class StoreDomain(
    @PrimaryKey
    val storeId: Int,
    val locationType: String,
    val name: String,
    val phone: String,
    val address: String,
    val address2: String,
    val city: String,
    val region: String,
    val fullPostalCode: String,
    val lat: Double,
    val lng: Double,
    val hoursAmPm: String,
    val distance: Double
    //val services: Service
)

fun List<Store>?.mapToDomainStores(): List<StoreDomain> =
    this?.map {
        StoreDomain(
            storeId = it.storeId ?: 0,
            locationType = "${it.locationType} - ${it.storeType}" ?: "not available",
            name = it.name ?: "not available",
            phone = it.phone ?: "not available",
            address = it.address ?: "not available",
            address2 = it.address2 ?: "not available",
            city = it.city ?: "not available",
            region = it.region ?: "not available",
            fullPostalCode = it.fullPostalCode ?: "not available",
            lat = it.lat ?: 0.0,
            lng = it.lng ?: 0.0,
            hoursAmPm = it.hoursAmPm ?: "not available",
            distance = it.distance ?: 0.0
            //services = (it.services ?: Service(service = "")) as Service
        )
    } ?: emptyList()