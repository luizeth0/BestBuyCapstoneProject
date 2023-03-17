package com.capstoneproject.bestbuy.database


import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ProductTable::class],
    version = 1
)
abstract class ProductsDatabase : RoomDatabase() {

    abstract fun getProductsDao(): ProductsDAO

}