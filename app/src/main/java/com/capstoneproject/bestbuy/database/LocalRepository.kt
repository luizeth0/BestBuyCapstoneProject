package com.capstoneproject.bestbuy.database

import com.capstoneproject.bestbuy.model.domain.ProductDomain
import com.capstoneproject.bestbuy.utils.UIState
import javax.inject.Inject


interface LocalRepository {
    suspend fun insertProduct(product: ProductDomain)
    suspend fun deleteProduct(product: ProductTable)
    suspend fun getProduct(): UIState<List<ProductTable>>
}

class LocalRepositoryImpl @Inject constructor(
    private val productsDAO: ProductsDAO
) : LocalRepository {

    override suspend fun insertProduct(product: ProductDomain) {
        try {
            val productTable = product.toDomainTable()
            productsDAO.insertProduct(productTable)
        } catch (e: Exception) {
            e.message
        }
    }

    override suspend fun deleteProduct(product: ProductTable) {
        try {
            productsDAO.deleteProduct(product)
        } catch (e: Exception) {
            e.message
        }
    }

    override suspend fun getProduct(): UIState<List<ProductTable>> {
        return try {
            UIState.SUCCESS(productsDAO.getProducts())
        } catch (e: Exception) {
            UIState.ERROR(e)
        }
    }

}