package com.capstoneproject.bestbuy.rest

import android.content.res.Resources
import com.capstoneproject.bestbuy.R
import com.capstoneproject.bestbuy.model.products.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BestBuyApi {

    @GET(PATH_PRODUCTS)
    suspend fun getProducts(
        @Query("format") format: String = "json",
        @Query("pageSize") page: String = "100",
        @Query("categoryId") cat: String = "abcat0501000",
        @Query("apiKey", encoded = true) apiKey: String = "raUvjWmgiqMJnI1N6FNJ8nbS"
    ): Response<ProductsResponse>

    @GET(Companion.PATH_STORES)
    suspend fun getStores(
        @Query("format") format: String = "json",
        @Query("pageSize") page: String = "100",
        @Query("apiKey", encoded = true) apiKey: String = "raUvjWmgiqMJnI1N6FNJ8nbS"
    ): Response<ProductsResponse>

    companion object{
        //https://api.bestbuy.com/v1/stores?apiKey=raUvjWmgiqMJnI1N6FNJ8nbS&format=json
        const val BASE_URL="https://api.bestbuy.com/"
        private const val PATH_PRODUCTS="v1/products"

        //https://api.bestbuy.com/v1/stores((area(33.9,-84.4,200)))?apiKey=raUvjWmgiqMJnI1N6FNJ8nbS&format=json
        private const val PATH_STORES="v1/stores"
        private const val PATH_CATEGORIES="v1/categories"
        private const val PATH_OPENBOX="beta/products/openBox"
        private const val PATH_RECOMMENDATIONS="beta/products/mostViewed"
    }
}