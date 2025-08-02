package com.somnathdey.auth.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.somnathdey.auth.domain.useCase.LoginUseCase
import com.somnathdey.auth.domain.useCase.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()
    private var _isLogin = MutableStateFlow(true)
    val isLogin = _isLogin.asStateFlow()

    fun onEmailChange(email: String) {
        _email.update { email }
    }

    fun onPasswordChange(password: String) {
        _password.update { password }
    }

    fun onToggleChange() {
        _isLogin.update { it.not() }
    }

    fun login() {
        loginUseCase(_email.value, _password.value)
            .onStart { _isLoading.update { true } }
            .onEach { result ->
                _isLoading.update { false }

                result.onSuccess { data ->

                }.onFailure { error ->
                }

            }
            .catch {
                _isLoading.update { false }
            }
            .launchIn(
                viewModelScope
            )
    }

    fun register() {
        registerUseCase(_email.value, _password.value)
            .onStart { _isLoading.update { true } }
            .onEach { result ->
                _isLoading.update { false }

                result.onSuccess { data ->

                }.onFailure { error ->
                }

            }
            .catch {
                _isLoading.update { false }
            }
            .launchIn(
                viewModelScope
            )
    }
}