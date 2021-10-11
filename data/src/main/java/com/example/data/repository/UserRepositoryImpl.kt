package com.example.data.repository

import com.example.data.network.ApiClient
import com.example.domain.repository.UserRepository

class UserRepositoryImpl(
    apiClient: ApiClient
) : UserRepository {
    override fun signIn(email: String, password: String): Result<String> {
        //todo firebase auth sign in
        return Result.success("succ")
    }

    override fun signUp(
        name: String,
        lastName: String,
        email: String,
        password: String
    ): Result<String> {
        //todo firebase auth sign up
        return Result.success("succ")
    }

    override fun resetPassword(email: String): Result<String> {
        //todo firebase auth reset password
        return Result.success("succ")
    }
}