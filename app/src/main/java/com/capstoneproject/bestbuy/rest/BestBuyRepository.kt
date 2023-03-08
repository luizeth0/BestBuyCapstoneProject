package com.capstoneproject.bestbuy.rest

import android.content.ContentValues.TAG
import android.util.Log
import com.capstoneproject.bestbuy.model.products.ProductsResponse
import com.capstoneproject.bestbuy.model.stores.StoresResponse
import com.capstoneproject.bestbuy.utils.FailureResponse
import com.capstoneproject.bestbuy.utils.NullResponse
import com.capstoneproject.bestbuy.utils.UIState
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface BestBuyRepository {
    suspend fun getProducts(): Flow<UIState<ProductsResponse>>
    suspend fun getStores(coordinates: LatLng): Flow<UIState<StoresResponse>>
}

class BestBuyRepositoryImpl @Inject constructor(
    private val bestBuyApi: BestBuyApi
): BestBuyRepository {

    override suspend fun getProducts(): Flow<UIState<ProductsResponse>> = flow {
        emit(UIState.LOADING)
        try {
            val response = bestBuyApi.getProducts()
            Log.d(TAG,"getProductsRepo: $response")
            if (response.isSuccessful) {
                response.body()?.let {
                    Log.d(TAG,"getProductsRepo: $it")
                    emit(UIState.SUCCESS(it))
                } ?: NullResponse()
            } else {
                throw FailureResponse(response.errorBody()?.string())
            }
        } catch (e: Exception) {
            Log.e(TAG, "getProductsRepo: $e")
            emit(UIState.ERROR(e))
        }
    }

    override suspend fun getStores(coordinates: LatLng): Flow<UIState<StoresResponse>> = flow {
        emit(UIState.LOADING)

        try {
            val response = bestBuyApi.getStores("${coordinates.latitude},${coordinates.longitude}")
            Log.d(TAG, "Hello1: $response")
            if (response.isSuccessful) {
                response.body()?.let {
                    Log.d(TAG, "Hello2: $it")
                    emit(UIState.SUCCESS(it))
                } ?: throw NullResponse()
            } else {
                throw FailureResponse(response.errorBody()?.string())
            }
        } catch (e: Exception) {
            emit(UIState.ERROR(e))
        }
    }

}