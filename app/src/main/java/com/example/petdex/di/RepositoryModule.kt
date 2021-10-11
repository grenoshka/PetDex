package com.example.petdex.di

import com.example.data.network.ApiClient
import com.example.data.repository.UserRepositoryImpl
import com.example.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
class RepositoryModule {
    @Provides
    @ViewModelScoped
    fun userRepository(
        apiClient: ApiClient
    ): UserRepository = UserRepositoryImpl(apiClient)
}