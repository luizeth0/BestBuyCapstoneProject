package com.capstoneproject.bestbuy.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstoneproject.bestbuy.model.domain.ProductDomain
import com.capstoneproject.bestbuy.model.domain.StoreDomain
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

    var sku = 0
    var name = ""
    var img = ""
    var type = ""
    var price = 0.0
    var rating = 0.0
    var reviewcount = 0

    private val _products : MutableLiveData<UIState<List<ProductDomain>>> = MutableLiveData(UIState.LOADING)
    val products : MutableLiveData<UIState<List<ProductDomain>>> get() = _products
    private val _stores : MutableLiveData<UIState<List<StoreDomain>>> = MutableLiveData(UIState.LOADING)
    val stores : MutableLiveData<UIState<List<StoreDomain>>> get() = _stores


    init {
        getProducts()
        //getStores()
    }

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