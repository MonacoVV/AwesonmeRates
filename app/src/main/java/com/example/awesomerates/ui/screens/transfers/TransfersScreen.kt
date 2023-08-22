package com.example.awesomerates.ui.screens.transfers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.awesomerates.ui.StyledPreview
import com.example.core.CustomCard

@Composable
@Preview
fun TransfersScreenPreview() {
    StyledPreview {
        TransfersScreen()
    }
}
@Composable
fun TransfersScreen(
    modifier: Modifier = Modifier,
    navigateToRates: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        CustomCard(
            modifier = modifier,
            hintText = "Transfers",
            buttonLabel = "To Rates",
            onButtonClick = navigateToRates
        )
    }
}