package com.somnathdey.firenotes.di

import com.somnathdey.auth.domain.repository.AuthRepository
import com.somnathdey.auth.domain.useCase.GetCurrentUserUseCase
import com.somnathdey.auth.domain.useCase.LoginUseCase
import com.somnathdey.auth.domain.useCase.LogoutUseCase
import com.somnathdey.auth.domain.useCase.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AuthDomainModule {

    @Provides
    fun provideGetCurrentUserUseCase(authRepository: AuthRepository): GetCurrentUserUseCase{
        return GetCurrentUserUseCase(authRepository)
    }

    @Provides
    fun provideLoginUseCase(authRepository: AuthRepository): LoginUseCase{
        return LoginUseCase(authRepository)
    }

    @Provides
    fun provideRegisterUseCase(authRepository: AuthRepository): RegisterUseCase{
        return RegisterUseCase(authRepository)
    }

    @Provides
    fun provideLogoutUseCase(authRepository: AuthRepository): LogoutUseCase{
        return LogoutUseCase(authRepository)
    }
}