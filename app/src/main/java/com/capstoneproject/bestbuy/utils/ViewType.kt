package com.capstoneproject.bestbuy.utils

import com.capstoneproject.bestbuy.model.domain.ProductDomain
import com.capstoneproject.bestbuy.model.domain.StoreDomain
import com.capstoneproject.bestbuy.model.products.Image

sealed class ViewType {
    data class PRODUCT(val productList: ProductDomain) : ViewType()
    data class IMAGES_PRODUCT(val imageList: Image) : ViewType()
    data class STORE(val storeList: StoreDomain) : ViewType()
}
