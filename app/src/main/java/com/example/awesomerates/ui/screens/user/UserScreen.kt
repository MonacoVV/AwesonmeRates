package com.example.awesomerates.ui.screens.user

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.core.CustomCard

@Preview
@Composable
fun UserScreen(
    modifier: Modifier = Modifier,
    navigateToTransfers: () -> Unit = {},
    onLogoutClicked: () -> Unit = {},
    userName: String = ""
) {
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        Row(horizontalArrangement = Arrangement.End) {
            Button(onClick = onLogoutClicked) {
                Text(text = "Logout")
            }
        }
        CustomCard(
            hintText = "User $userName Info",
            buttonLabel = "To Transfers",
            onButtonClick = navigateToTransfers
        )
    }

}