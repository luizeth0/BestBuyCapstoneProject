package com.capstoneproject.bestbuy.utils

import com.capstoneproject.bestbuy.model.domain.ProductDomain
import com.capstoneproject.bestbuy.model.domain.StoreDomain

sealed class ViewType {
    data class PRODUCT(val productList: ProductDomain) : ViewType()
    data class DETAILS_PRODUCT(val productList: ProductDomain) : ViewType()
    data class STORE(val storeList: StoreDomain) : ViewType()
}
