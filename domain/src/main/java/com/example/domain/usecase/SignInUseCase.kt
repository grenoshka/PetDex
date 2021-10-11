package com.example.domain.usecase

import com.example.domain.base.BaseUseCase
import com.example.domain.repository.UserRepository

class SignInUseCase(private val userRepository: UserRepository) :
    BaseUseCase<Result<String>, SignInParams> {
    override fun invoke(params: SignInParams): Result<String> {
        return userRepository.signIn(params.email, params.password)
    }
}

class SignInParams(val email: String, val password: String)