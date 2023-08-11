package com.example.awesomerates.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.core.CustomCard

@Composable
fun TransfersScreen(modifier: Modifier, onActionClick: () -> Unit) {
    CustomCard(
        modifier = modifier,
        hintText = "Transfers",
        buttonLabel = "To Rates",
        onButtonClick = onActionClick
    )
}