package com.somnathdey.auth.domain.useCase

import com.somnathdey.auth.domain.repository.AuthRepository

class LogoutUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke() = authRepository.logout()
}
