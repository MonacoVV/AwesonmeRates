package com.example.awesomerates.navigation.graphs

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.awesomerates.domain.state.MainScreenStateBuilder
import com.example.awesomerates.navigation.Screens
import com.example.awesomerates.navigation.Screens.LoginFlow
import com.example.awesomerates.ui.screens.login.LoginInfoScreen
import com.example.awesomerates.ui.screens.login.LoginScreen
import com.example.awesomerates.ui.screens.login.RegistrationScreen
import com.example.awesomerates.ui.viewmodel.LoginViewModel
import org.koin.androidx.compose.getViewModel

fun NavGraphBuilder.loginGraph(navController: NavController, onComposing: (MainScreenStateBuilder.() -> Unit) -> Unit) {
    navigation(startDestination = LoginFlow.LoginInfo.route, route = LoginFlow.route) {
        loginInfoScreen(navController, onComposing)
        loginScreen(navController, onComposing)
        registrationScreen(navController, onComposing)
    }
}

fun NavGraphBuilder.loginInfoScreen(navController: NavController,  onComposing: (MainScreenStateBuilder.() -> Unit) -> Unit) {
    composable(LoginFlow.LoginInfo.route) {
        LaunchedEffect(Unit) {
            onComposing {
                topBarVisible = false
                bottomNavigationVisible = false
            }        }
        LoginInfoScreen(
            navigateToLogin = {
                navController.navigate(LoginFlow.Login.route)
            },
            navigateToRegistration = {
                navController.navigate(LoginFlow.Registration.route)
            },
        )
    }
}

fun NavGraphBuilder.loginScreen(navController: NavController, onComposing: (MainScreenStateBuilder.() -> Unit) -> Unit) {
    composable(LoginFlow.Login.route) {
        LaunchedEffect(Unit) {
            onComposing {
                topBarVisible = false
                bottomNavigationVisible = false
            }
        }
        val viewModel: LoginViewModel = getViewModel()
        LoginScreen(
            onLoginComplete = {
                viewModel.onLoginClicked(it)
                navController.navigate(Screens.Rates.route)
            }
        )
    }
}

fun NavGraphBuilder.registrationScreen(navController: NavController,  onComposing: (MainScreenStateBuilder.() -> Unit) -> Unit) {
    composable(LoginFlow.Registration.route) {
        LaunchedEffect(Unit) {
            onComposing {
                topBarVisible = false
                bottomNavigationVisible = false
            }
        }
        RegistrationScreen(
            modifier = Modifier
                .fillMaxSize()
                .imePadding(),
        )
    }
}
