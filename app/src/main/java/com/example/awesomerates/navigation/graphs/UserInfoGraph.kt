package com.example.awesomerates.navigation.graphs

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.awesomerates.domain.state.MainScreenStateBuilder
import com.example.awesomerates.navigation.Screens
import com.example.awesomerates.ui.screens.user.UserScreen
import com.example.awesomerates.ui.viewmodel.UserViewModel
import org.koin.androidx.compose.getViewModel

fun NavGraphBuilder.userInfoScreen(
    navController: NavController,
    onComposing: (MainScreenStateBuilder.() -> Unit) -> Unit
) {
    composable(Screens.User.route) {
        val viewModel: UserViewModel = getViewModel()
        LaunchedEffect(Unit) {
            onComposing {
                title = Screens.User.name
                bottomNavigationVisible = true
                topBarVisible = true
            }
        }
        val nameState = viewModel.userFlow.collectAsState()
        UserScreen(
            userName = nameState.value,
            onLogoutClicked = {
                viewModel.onLogoutClicked()
            },
            navigateToTransfers = {
                navController.navigate(Screens.Transfers.route)
            }
        )
    }
}