package com.capstoneproject.bestbuy.rest

import android.content.res.Resources
import com.capstoneproject.bestbuy.R
import com.capstoneproject.bestbuy.model.products.ProductsResponse
import com.capstoneproject.bestbuy.model.stores.StoresResponse
import com.capstoneproject.bestbuy.viewmodel.BestBuyViewModel
import com.google.android.gms.maps.model.LatLng
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.net.URLEncoder

interface BestBuyApi {

    @GET(PATH_PRODUCTS)
    suspend fun getProducts(
        @Query("page") numPage: Int,
        @Query("format") format: String = "json",
        @Query("pageSize") page: String = "100",
        @Query("apiKey", encoded = true) apiKey: String = APYKEY
    ): Response<ProductsResponse>

    @GET(PATH_PRODUCTS + CATEGORY)
    suspend fun getProductsbyCat(
        @Query("") cat: String,
        @Query("format") format: String = "json",
        @Query("pageSize") page: String = "100",
        @Query("apiKey", encoded = true) apiKey: String = APYKEY
    ): Response<ProductsResponse>

    @GET(PATH_STORES + "{coordinates}")
    suspend fun getStores(
        @Path("coordinates", encoded = true) coordinates: String,
        @Query("format") format: String = "json",
        @Query("pageSize") page: String = "100",
        @Query("apiKey", encoded = true) apiKey: String = APYKEY
    ): Response<StoresResponse>

    companion object{
        private const val APYKEY = "raUvjWmgiqMJnI1N6FNJ8nbS"
        //https://api.bestbuy.com/v1/stores?apiKey=raUvjWmgiqMJnI1N6FNJ8nbS&format=json
        const val BASE_URL = "https://api.bestbuy.com/"
        private const val PATH_PRODUCTS ="v1/products"
        private const val CATEGORY = "((categoryPath.id={cat}))"

        //https://api.bestbuy.com/v1/stores((area(33.9,-84.4,200)))?apiKey=raUvjWmgiqMJnI1N6FNJ8nbS&format=json
        private const val PATH_STORES = "v1/stores"

        private const val PATH_CATEGORIES ="v1/categories"
        private const val PATH_OPENBOX ="beta/products/openBox"
        private const val PATH_RECOMMENDATIONS ="beta/products/mostViewed"
    }
}