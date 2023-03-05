package com.capstoneproject.bestbuy.rest

import android.content.ContentValues.TAG
import android.util.Log
import com.capstoneproject.bestbuy.model.products.ProductsResponse
import com.capstoneproject.bestbuy.utils.FailureResponse
import com.capstoneproject.bestbuy.utils.NullResponse
import com.capstoneproject.bestbuy.utils.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface BestBuyRepository {
    suspend fun getProducts(): Flow<UIState<ProductsResponse>>
}

class BestBuyRepositoryImpl @Inject constructor(
    private val bestBuyApi: BestBuyApi
): BestBuyRepository {

    override suspend fun getProducts(): Flow<UIState<ProductsResponse>> = flow {
        emit(UIState.LOADING)
        try {
            val response = bestBuyApi.getProducts()
            Log.d(TAG,"getProducts: $response")
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(UIState.SUCCESS(it))
                } ?: NullResponse()
            } else {
                throw FailureResponse(response.errorBody()?.string())
            }
        } catch (e: Exception) {
            emit(UIState.ERROR(e))
        }
    }

}