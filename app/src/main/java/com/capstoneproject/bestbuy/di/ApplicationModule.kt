package com.capstoneproject.bestbuy.di

import android.content.Context
import androidx.room.Room
import com.capstoneproject.bestbuy.database.ProductsDAO
import com.capstoneproject.bestbuy.database.ProductsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    fun providesDatabase(
        @ApplicationContext context: Context
    ): ProductsDatabase =
        Room.databaseBuilder(
            context,
            ProductsDatabase::class.java,
            "products-db"
        ).build()

    @Provides
    fun providesDao(
        productDatabase: ProductsDatabase
    ): ProductsDAO = productDatabase.getProductsDao()


}