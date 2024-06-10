package com.example.airsofthub.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.airsofthub.data.UserDao

class LoginViewModel(private val userDao: UserDao) : ViewModel() {
   internal val username = mutableStateOf("")
   internal val password = mutableStateOf("")

    fun onUsernameChange(newUsername: String) {
        username.value = newUsername
    }

    fun onPasswordChange(newPassword: String) {
        password.value = newPassword
    }

    fun onLogin(username: String, password: String): Boolean {
        return userDao.getUser(username, password) != null
    }

}