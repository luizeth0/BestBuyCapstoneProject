package com.capstoneproject.bestbuy.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstoneproject.bestbuy.model.products.ProductsResponse
import com.capstoneproject.bestbuy.rest.BestBuyRepository
import com.capstoneproject.bestbuy.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BestBuyViewModel @Inject constructor(
    private val bestBuyRepository: BestBuyRepository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): ViewModel() {

    private val _products : MutableLiveData<UIState<ProductsResponse>> = MutableLiveData(UIState.LOADING)
    val products : MutableLiveData<UIState<ProductsResponse>> get() = _products

    init {
        getProducts()
    }

    private fun getProducts() {
        run {
            viewModelScope.launch(ioDispatcher) {
                bestBuyRepository.getProducts().collect() {
                    Log.d(TAG, "getProductsVM:-- $it")
                    _products.postValue(it)
                    Log.d(TAG, "getProductsVM2:-- $_products")
                }
            }
        }
    }

}