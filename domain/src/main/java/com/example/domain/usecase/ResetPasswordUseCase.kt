package com.example.domain.usecase

import com.example.domain.base.BaseUseCase
import com.example.domain.repository.UserRepository
import javax.inject.Inject

class ResetPasswordUseCase  @Inject constructor(private val userRepository: UserRepository) :
    BaseUseCase<Result<String>, ResetPasswordParams> {
    override suspend fun invoke(params: ResetPasswordParams): Result<String> {
        return userRepository.resetPassword(params.email)
    }

}

class ResetPasswordParams(val email: String)