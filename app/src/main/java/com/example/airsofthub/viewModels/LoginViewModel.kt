package com.example.airsofthub.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
class LoginViewModel : ViewModel() {
   internal val username = mutableStateOf("")
   internal val password = mutableStateOf("")

    fun onUsernameChange(newUsername: String) {
        username.value = newUsername
    }

    fun onPasswordChange(newPassword: String) {
        password.value = newPassword
    }

    fun onLogin() {
        // Login logic
    }
}