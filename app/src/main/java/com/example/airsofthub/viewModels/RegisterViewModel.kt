package com.example.airsofthub.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.airsofthub.data.User
import com.example.airsofthub.data.UserDao

class RegisterViewModel(private val userDao: UserDao) : ViewModel() {
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
        val newUser = User(username.value, password.value)
        userDao.insertUser(newUser)
    }

}
