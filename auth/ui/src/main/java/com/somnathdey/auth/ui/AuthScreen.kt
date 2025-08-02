package com.somnathdey.auth.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun AuthScreen(modifier: Modifier = Modifier) {
    val viewModel = hiltViewModel<AuthViewModel>()

    val email by viewModel.email.collectAsStateWithLifecycle()
    val password by viewModel.password.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val isLogin by viewModel.isLogin.collectAsStateWithLifecycle()

    AuthScreenContent(
        modifier = modifier.fillMaxSize(),
        isLoading = isLoading,
        isLogin = isLogin,
        onToggleChange = viewModel::onToggleChange,
        email = email,
        password = password,
        onEmailChange = viewModel::onEmailChange,
        onPasswordChange = viewModel::onPasswordChange,
        onLogin = viewModel::login,
        onRegister = viewModel::register
    )
}

@Composable
fun AuthScreenContent(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    isLogin: Boolean,
    onToggleChange: () -> Unit,
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLogin: () -> Unit,
    onRegister: () -> Unit
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
    ) {
        Text(
            "Fire Notes",
            style = MaterialTheme
                .typography.titleLarge,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text("Email")
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = email,
            onValueChange = onEmailChange,
            modifier = Modifier
                .fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text("Password")
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = password,
            onValueChange = onPasswordChange,
            modifier = Modifier
                .fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(24.dp))

        if (isLoading) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            if (isLogin) {
                Button(
                    onClick = onLogin,
                    modifier = Modifier
                        .height(45.dp)
                ) {
                    Text("SignIn")
                }
                Text(
                    text = "Create an account? SignUp",
                    modifier = Modifier.clickable {
                        onToggleChange()
                    })
            } else {
                Button(
                    onClick = onRegister,
                    modifier = Modifier
                        .height(45.dp)
                ) {
                    Text("SignUp")
                }
                Text(
                    text = "Already have an account? Login",
                    modifier = Modifier.clickable {
                        onToggleChange()
                    })
            }
        }
    }
}