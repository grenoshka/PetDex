package com.example.domain.repository

interface UserRepository {
    fun signIn(email: String, password: String): Result<String>
    fun signUp(name: String, lastName: String, email: String, password: String): Result<String>
    fun resetPassword(email: String): Result<String>
}