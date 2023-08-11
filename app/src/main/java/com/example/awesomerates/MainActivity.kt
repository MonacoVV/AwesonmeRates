package com.example.awesomerates

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.awesomerates.domain.User
import com.example.awesomerates.navigation.ApplicationDestination
import com.example.awesomerates.navigation.back
import com.example.awesomerates.ui.RatesScreen
import com.example.awesomerates.ui.TransfersScreen
import com.example.awesomerates.ui.UserScreenWrap
import com.example.awesomerates.ui.theme.AwesomeRatesTheme
import com.example.awesomerates.ui.viewmodel.UserViewModel
import com.example.core.CustomCard
import dev.olshevski.navigation.reimagined.AnimatedNavHost
import dev.olshevski.navigation.reimagined.navigate
import dev.olshevski.navigation.reimagined.rememberNavController
import org.koin.android.ext.android.inject
import org.koin.androidx.compose.getViewModel


class MainActivity : ComponentActivity() {

    val user: User by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val nav =
                rememberNavController<ApplicationDestination>(startDestination = ApplicationDestination.Transfers)
            BackHandler { nav.back() }

            AwesomeRatesTheme {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    GreetingScreen(user.name)
//                }

                AnimatedNavHost(
                    controller = nav,
                    emptyBackstackPlaceholder = { nav.navigate(ApplicationDestination.Transfers) },
                    transitionSpec = { _, _, to ->
                        if (to == ApplicationDestination.Transfers) {
                            slideIntoContainer(
                                towards = AnimatedContentScope.SlideDirection.Start,
                                initialOffset = { it },
                            ) with fadeOut() + slideOutOfContainer(
                                towards = AnimatedContentScope.SlideDirection.Start,
                                targetOffset = { it / 3 },
                            )
                        } else {
                            fadeIn() + slideIntoContainer(
                                towards = AnimatedContentScope.SlideDirection.End,
                                initialOffset = { it / 3 },
                            ) with slideOutOfContainer(
                                towards = AnimatedContentScope.SlideDirection.End,
                                targetOffset = { it },
                            )
                        }
                    },
                ) { dest ->
                    when (dest) {
                        ApplicationDestination.Rates -> {
                            RatesScreen(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .imePadding(),
                                onActionClick = {
                                    nav.navigate(ApplicationDestination.User)
                                }
                            )
                        }

                        ApplicationDestination.Transfers -> {
                            TransfersScreen(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .imePadding(),
                                onActionClick = {
                                    nav.navigate(ApplicationDestination.Rates)
                                }
                            )
                        }

                        ApplicationDestination.User -> {
                            UserScreenWrap(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .imePadding(),
                                onActionClick = {
                                    nav.navigate(ApplicationDestination.Transfers)
                                }
                            )
                        }

                        is ApplicationDestination.Credentials -> {

                        }
                    }

                }
            }
        }
    }
}

@Composable
fun GreetingScreen(
    name: String,
    modifier: Modifier = Modifier,
    viewModel: UserViewModel = getViewModel()
) {
    CustomCard(modifier, viewModel.userName)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AwesomeRatesTheme {
        GreetingScreen("Android")
    }
}