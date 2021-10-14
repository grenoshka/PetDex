package com.example.domain.usecase

import com.example.domain.base.BaseUseCase
import com.example.domain.repository.UserRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(private val userRepository: UserRepository) :
    BaseUseCase<Result<String>, SignInParams> {
    override suspend fun invoke(params: SignInParams): Result<String> {
        return userRepository.signIn(params.email, params.password)
    }
}

class SignInParams(val email: String, val password: String)