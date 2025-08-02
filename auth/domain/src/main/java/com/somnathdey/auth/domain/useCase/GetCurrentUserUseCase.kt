package com.somnathdey.auth.domain.useCase

import com.somnathdey.auth.domain.repository.AuthRepository

class GetCurrentUserUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke() = authRepository.getCurrentUser()
}