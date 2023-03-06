package com.capstoneproject.bestbuy.viewmodel

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
        viewModelScope.launch(ioDispatcher) {
            bestBuyRepository.getProducts().collect() {
                _products.postValue(it)
            }
        }
    }

}