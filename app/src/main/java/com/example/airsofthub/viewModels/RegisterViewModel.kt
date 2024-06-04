package com.example.airsofthub.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {
    internal val username = mutableStateOf("")
    internal val password = mutableStateOf("")
    internal val email = mutableStateOf("")


    fun onUsernameChange(newUsername: String) {
        username.value = newUsername
    }

    fun onPasswordChange(newPassword: String) {
        password.value = newPassword
    }

    fun onEmailChange(newEmail: String) {
        email.value = newEmail
    }

    fun onRegister() {
        // Register logic
    }
}
