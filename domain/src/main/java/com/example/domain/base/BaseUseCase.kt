package com.example.domain.base

interface BaseUseCase<T, in Params> {
    suspend operator fun invoke(params:Params): T
}