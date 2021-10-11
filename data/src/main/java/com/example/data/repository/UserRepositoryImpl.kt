package com.example.data.repository

import com.example.domain.repository.UserRepository

class UserRepositoryImpl : UserRepository {
    override fun signIn(email: String, password: String): Result<String> {
        //todo firebase auth sign in
    }

    override fun signUp(
        name: String,
        lastName: String,
        email: String,
        password: String
    ): Result<String> {
        //todo firebase auth sign up
    }

    override fun resetPassword(email: String): Result<String> {
        //todo firebase auth reset password
    }
}