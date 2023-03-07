package com.capstoneproject.bestbuy.utils

import com.capstoneproject.bestbuy.model.domain.ProductDomain

sealed class ViewType {
    data class PRODUCT(val productList: ProductDomain) : ViewType()
}
