package com.capstoneproject.bestbuy.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstoneproject.bestbuy.model.products.ProductsResponse
import com.capstoneproject.bestbuy.model.stores.StoresResponse
import com.capstoneproject.bestbuy.rest.BestBuyRepository
import com.capstoneproject.bestbuy.utils.UIState
import com.google.android.gms.maps.model.LatLng
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

    var coordinates: LatLng = LatLng(0.0, 0.0)
    var address = ""
    var city = ""
    var region = ""
    var lat = ""
    var lng = ""
    var hoursAmPm = ""
    var phone = ""
    var poscode = ""
    var distance =""

    private val _products : MutableLiveData<UIState<ProductsResponse>> = MutableLiveData(UIState.LOADING)
    val products : MutableLiveData<UIState<ProductsResponse>> get() = _products
    private val _stores : MutableLiveData<UIState<StoresResponse>> = MutableLiveData(UIState.LOADING)
    val stores : MutableLiveData<UIState<StoresResponse>> get() = _stores


    /*init {
        getProducts()
    }*/

    fun getProducts() {
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

    fun getStores() {
        run {
            viewModelScope.launch(ioDispatcher) {
                bestBuyRepository.getStores(coordinates).collect() {
                    Log.d(TAG, "getStoresVM:-- $it")
                    _stores.postValue(it)
                    Log.d(TAG, "getStoresVM2:-- $_stores")
                }
            }
        }
    }

}