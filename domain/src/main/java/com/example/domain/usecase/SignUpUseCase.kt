package com.example.domain.usecase

import com.example.domain.base.BaseUseCase
import com.example.domain.repository.UserRepository
import javax.inject.Inject

class SignUpUseCase  @Inject constructor (private val userRepository: UserRepository) :
    BaseUseCase<Result<String>, SignUpParams> {
    override suspend fun invoke(params: SignUpParams): Result<String> {
        return userRepository.signUp(params.name, params.lastName, params.email, params.password)
    }
}

class SignUpParams(val name: String, val lastName: String, val email: String, val password: String)