package com.example.domain.repository


interface UserRepository {
    suspend fun signIn(email: String, password: String): Result<String>
    suspend fun signUp(name: String, lastName: String, email: String, password: String): Result<String>
    suspend fun resetPassword(email: String): Result<String>
}