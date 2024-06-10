package com.example.airsofthub.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.airsofthub.screens.AppScreen
import com.example.airsofthub.screens.Event
import com.example.airsofthub.screens.EventDetailsScreen
import com.example.airsofthub.screens.EventEntryScreen
import com.example.airsofthub.screens.Login
import com.example.airsofthub.screens.LoginRegister
import com.example.airsofthub.screens.Register
import com.example.airsofthub.viewModels.EventViewModel
import com.example.airsofthub.viewModels.LoginViewModel
import com.example.airsofthub.viewModels.RegisterViewModel
import androidx.compose.runtime.remember as remember

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val events = remember { mutableStateOf(listOf<Event>()) }


    NavHost(navController, startDestination = Routes.LOGIN_REGISTER) {
        composable(Routes.LOGIN_REGISTER) {
            LoginRegister(
                navigateToLogin = { navController.navigate(Routes.LOGIN) },
                navigateToRegister = { navController.navigate(Routes.REGISTER) }
            )
        }
        composable(Routes.LOGIN) {
            val loginViewModel: LoginViewModel = viewModel<LoginViewModel>()
            Login(
                viewModel = loginViewModel,
                onBack = { navController.popBackStack() },
                onLoginSuccess = { navController.navigate(Routes.APP_SCREEN) }
            )
        }
        composable(Routes.REGISTER) {
            val registerViewModel: RegisterViewModel = viewModel<RegisterViewModel>()
            Register(
                viewModel = registerViewModel,
                onBack = { navController.popBackStack() },
                onRegisterSuccess = { navController.navigate(Routes.APP_SCREEN) }
            )
        }
        composable(Routes.APP_SCREEN) {
            AppScreen(
                events = events.value,
                navigateToEventEntry = { navController.navigate(Routes.EVENT_ENTRY) },
                navigateToEventDetails = { event ->
                    navController.navigate("${Routes.EVENT_DETAILS}/${event.name}")
                }
            )
        }

        composable(Routes.EVENT_ENTRY) {
            val eventViewModel: EventViewModel = viewModel<EventViewModel>()
            EventEntryScreen(
                viewModel = eventViewModel,
                onEventEntry = { newEvent ->
                events.value += newEvent
                navController.popBackStack()
            })
        }
        composable("${Routes.EVENT_DETAILS}/{eventName}") { backStackEntry ->
            val eventName = backStackEntry.arguments?.getString("eventName")
            val event = events.value.find { it.name == eventName }
            event?.let {
                EventDetailsScreen(event = it)
            }
        }
    }
}
