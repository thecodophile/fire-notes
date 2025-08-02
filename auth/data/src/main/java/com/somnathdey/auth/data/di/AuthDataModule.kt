package com.somnathdey.auth.data.di

import com.google.firebase.auth.FirebaseAuth
import com.somnathdey.auth.data.repository.AuthRepositoryImpl
import com.somnathdey.auth.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AuthDataModule {

    @Singleton
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Singleton
    @Provides
    fun provideAuthRepository(auth: FirebaseAuth): AuthRepository{
        return AuthRepositoryImpl(auth)
    }
}