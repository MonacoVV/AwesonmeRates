package com.example.awesomerates

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.awesomerates.navigation.Screens
import com.example.awesomerates.navigation.graphs.loginGraph
import com.example.awesomerates.navigation.graphs.ratesScreen
import com.example.awesomerates.navigation.graphs.transfersScreen
import com.example.awesomerates.navigation.graphs.userInfoScreen
import com.example.awesomerates.ui.theme.AwesomeRatesTheme
import com.example.awesomerates.ui.viewmodel.MainViewModel
import com.example.core.AppBar
import org.koin.androidx.compose.getViewModel


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val mainViewModel: MainViewModel = getViewModel()
            val nav = rememberNavController()

            AwesomeRatesTheme {
                Scaffold(
                    topBar = top@{
                        if (!mainViewModel.state.topBarVisible) return@top
                        AppBar(
                            title = { Text(mainViewModel.state.title) },
                            navigationIconVisible = mainViewModel.state.drawerEnabled,
                            onNavigationIconClick = { nav.popBackStack() },
                        )
                    },
                    bottomBar = bottom@{
                        if (!mainViewModel.state.bottomNavigationVisible) return@bottom
                        BottomAppBar {
                            val navBackStackEntry by nav.currentBackStackEntryAsState()
                            val currentDestination = navBackStackEntry?.destination
                            listOf(Screens.Rates, Screens.Transfers, Screens.User)
                                .forEach { screen ->
                                    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
                                    NavigationBarItem(
                                        icon = {
                                            Icon(
                                                Icons.Filled.Favorite,
                                                contentDescription = null
                                            )
                                        },
                                        label = { Text(screen.name) },
                                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                                        onClick = {
                                            if (!selected) nav.navigate(screen.route) {
//                                                popUpTo(nav.graph.findStartDestination().id) {
//                                                    saveState = true
//                                                }
//                                                launchSingleTop = true
//                                                restoreState = true
                                            }
                                        }
                                    )
                                }
                        }
                    }
                ) { paddings ->
                    NavHost(
                        modifier = Modifier.padding(paddings),
                        navController = nav,
                        startDestination = if (mainViewModel.isUserAuthorized()) Screens.Rates.route else Screens.LoginFlow.route
                    ) {
                        ratesScreen(nav, mainViewModel::updateState)
                        transfersScreen(nav, mainViewModel::updateState)
                        userInfoScreen(nav, mainViewModel::updateState)
                        loginGraph(nav, mainViewModel::updateState)
                    }
                }
            }
        }
    }
}