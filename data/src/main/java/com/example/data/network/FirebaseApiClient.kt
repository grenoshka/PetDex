package com.example.data.network

class FirebaseApiClient: ApiClient {
    override fun signIn(email: String, password: String): Result<String> {
        TODO("Not yet implemented")
    }

    override fun signUp(
        name: String,
        lastName: String,
        email: String,
        password: String
    ): Result<String> {
        TODO("Not yet implemented")
    }

    override fun resetPassword(email: String): Result<String> {
        TODO("Not yet implemented")
    }
}