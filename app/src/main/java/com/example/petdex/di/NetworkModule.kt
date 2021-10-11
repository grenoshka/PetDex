package com.example.petdex.di

import com.example.data.network.ApiClient
import com.example.data.network.FirebaseApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Provides
    @Singleton
    fun apiClient(): ApiClient = FirebaseApiClient()
}