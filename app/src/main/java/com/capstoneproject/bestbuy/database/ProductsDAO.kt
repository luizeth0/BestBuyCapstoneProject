package com.capstoneproject.bestbuy.database

import androidx.room.*

@Dao
interface ProductsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(vararg product: ProductTable)

    @Delete
    suspend fun deleteProduct(vararg product: ProductTable)

    @Query("SELECT * FROM products")
    suspend fun getProducts(): List<ProductTable>

}