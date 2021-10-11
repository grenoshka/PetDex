package com.example.domain.usecase

import com.example.domain.base.BaseUseCase
import com.example.domain.repository.UserRepository

class ResetPasswordUseCase(private val userRepository: UserRepository) :
    BaseUseCase<Result<String>, ResetPasswordParams> {
    override fun invoke(params: ResetPasswordParams): Result<String> {
        return userRepository.resetPassword(params.email)
    }

}

class ResetPasswordParams(val email: String)