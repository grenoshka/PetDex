package com.example.data.network

interface ApiClient {
    fun signIn(email:String, password:String): String
    fun signUp(name:String, lastName:String, email:String, password: String): String
    fun resetPassword(email: String): String
}