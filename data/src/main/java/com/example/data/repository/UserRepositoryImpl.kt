package com.example.data.repository

import com.example.data.network.ApiClient
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiClient: ApiClient
) : UserRepository {
    override suspend fun signIn(email: String, password: String): Result<String> {
        return withContext(Dispatchers.IO) {
            try {
                Result.success(apiClient.signIn(email, password))
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    override suspend fun signUp(
        name: String,
        lastName: String,
        email: String,
        password: String
    ): Result<String> {
        return withContext(Dispatchers.IO) {
            try {
                Result.success(apiClient.signUp(name, lastName, email, password))
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    override suspend fun resetPassword(email: String): Result<String> {
        return withContext(Dispatchers.IO) {
            try {
                Result.success(apiClient.resetPassword(email))
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
}