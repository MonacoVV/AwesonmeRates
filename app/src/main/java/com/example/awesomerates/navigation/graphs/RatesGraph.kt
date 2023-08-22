package com.example.awesomerates.navigation.graphs
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.awesomerates.domain.state.MainScreenStateBuilder
import com.example.awesomerates.navigation.Screens
import com.example.awesomerates.navigation.Screens.Rates
import com.example.awesomerates.ui.screens.rates.RatesScreen

fun NavGraphBuilder.ratesScreen(navController: NavController, onComposing: (MainScreenStateBuilder.() -> Unit) -> Unit) {
    composable(Rates.route) {
        LaunchedEffect(Unit) {
            onComposing.invoke {
                title = Rates.name
                topBarVisible = true
                bottomNavigationVisible = true
            }
        }
        RatesScreen(
            onActionClick = {
                navController.navigate(Screens.User.route)
            }
        )
    }
}