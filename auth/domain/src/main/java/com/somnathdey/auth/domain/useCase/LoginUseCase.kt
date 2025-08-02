package com.somnathdey.auth.domain.useCase

import com.somnathdey.auth.domain.repository.AuthRepository

class LoginUseCase(
    private val authRepository: AuthRepository
) {
    operator fun invoke(email: String, password: String) = authRepository.login(email, password)
}