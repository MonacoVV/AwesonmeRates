package com.example.awesomerates.ui.screens.user

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
    navigateToTransfers: () -> Unit = {},
    userName: String = "Preview"
) {
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        CustomCard(
            hintText = "User $userName Info",
            buttonLabel = "To Transfers",
            onButtonClick = navigateToTransfers
        )
    }

}