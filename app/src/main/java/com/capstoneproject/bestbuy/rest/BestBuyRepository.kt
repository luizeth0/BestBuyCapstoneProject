package com.capstoneproject.bestbuy.rest

import android.content.ContentValues.TAG
import android.util.Log
import com.capstoneproject.bestbuy.model.domain.ProductDomain
import com.capstoneproject.bestbuy.model.domain.StoreDomain
import com.capstoneproject.bestbuy.model.domain.mapToDomainProducts
import com.capstoneproject.bestbuy.model.domain.mapToDomainStores
import com.capstoneproject.bestbuy.model.products.ProductsResponse
import com.capstoneproject.bestbuy.model.stores.StoresResponse
import com.capstoneproject.bestbuy.utils.FailureResponse
import com.capstoneproject.bestbuy.utils.NullResponse
import com.capstoneproject.bestbuy.utils.UIState
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.net.URLEncoder
import javax.inject.Inject

interface BestBuyRepository {
    suspend fun getProducts(): Flow<UIState<List<ProductDomain>>>
    suspend fun getStores(coordinates: LatLng): Flow<UIState<List<StoreDomain>>>
}

class BestBuyRepositoryImpl @Inject constructor(
    private val bestBuyApi: BestBuyApi
): BestBuyRepository {

    override suspend fun getProducts(): Flow<UIState<List<ProductDomain>>> = flow {
        emit(UIState.LOADING)
        try {
            val response = bestBuyApi.getProducts()
            Log.d(TAG,"getProductsRepo: $response")
            if (response.isSuccessful) {
                response.body()?.let {
                    Log.d(TAG,"getProductsRepo: $it")
                    emit(UIState.SUCCESS(it.products.mapToDomainProducts()))
                } ?: NullResponse()
            } else {
                throw FailureResponse(response.errorBody()?.string())
            }
        } catch (e: Exception) {
            Log.e(TAG, "getProductsRepoError: $e")
            emit(UIState.ERROR(e))
        }
    }

    override suspend fun getStores(coordinates: LatLng): Flow<UIState<List<StoreDomain>>> = flow {
        emit(UIState.LOADING)

        try {
            val encodedEndpoint = URLEncoder.encode("(area(${coordinates.latitude},${coordinates.longitude},200))", "UTF-8")
            val response = bestBuyApi.getStores(encodedEndpoint)
            Log.d(TAG, "Hello1: $response")
            if (response.isSuccessful) {
                response.body()?.let {
                    Log.d(TAG, "Hello2: $it")
                    emit(UIState.SUCCESS(it.stores.mapToDomainStores()))
                } ?: throw NullResponse()
            } else {
                throw FailureResponse(response.errorBody()?.string())
            }
        } catch (e: Exception) {
            emit(UIState.ERROR(e))
        }
    }

}