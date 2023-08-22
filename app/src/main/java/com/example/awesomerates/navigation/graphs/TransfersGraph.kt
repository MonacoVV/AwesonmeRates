package com.example.awesomerates.navigation.graphs

import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.awesomerates.domain.state.MainScreenState
import com.example.awesomerates.domain.state.MainScreenStateBuilder
import com.example.awesomerates.navigation.Screens
import com.example.awesomerates.ui.screens.transfers.TransfersScreen
import com.example.awesomerates.ui.viewmodel.UserViewModel
import org.koin.androidx.compose.getViewModel



fun NavGraphBuilder.transfersScreen(navController: NavController, onComposing: (MainScreenStateBuilder.() -> Unit) -> Unit) {
    composable(Screens.Transfers.route) {
        LaunchedEffect(Unit) {
            onComposing {
                title = Screens.Transfers.name
                bottomNavigationVisible = true
                topBarVisible = true

            }
        }
        TransfersScreen(
            navigateToRates = {
                navController.navigate(Screens.Rates.route)
            }
        )
    }
}

