package com.example.awesomerates.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.awesomerates.ui.viewmodel.UserViewModel
import com.example.core.CustomCard
import org.koin.androidx.compose.getViewModel


@Composable
fun UserScreenWrap(
    modifier: Modifier = Modifier,
    onActionClick: () -> Unit,
    viewModel: UserViewModel = getViewModel()
) {
    UserScreen(
        modifier = modifier,
        onActionClick,
        userName = viewModel.userName
    )
}

@Preview
@Composable
fun UserScreen(
    modifier: Modifier = Modifier,
    onNavigationClick: () -> Unit = {},
    userName: String = "Preview"
) {
    CustomCard(
        modifier = modifier,
        hintText = "User $userName Info",
        buttonLabel = "To Transfers",
        onButtonClick = onNavigationClick
    )
}