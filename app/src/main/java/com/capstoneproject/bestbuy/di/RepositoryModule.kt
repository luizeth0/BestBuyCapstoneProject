package com.capstoneproject.bestbuy.di

import com.capstoneproject.bestbuy.rest.BestBuyRepository
import com.capstoneproject.bestbuy.rest.BestBuyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun providesBestBuyRepositoryImpl(
        bestBuyRepositoryImpl: BestBuyRepositoryImpl
    ): BestBuyRepository
}