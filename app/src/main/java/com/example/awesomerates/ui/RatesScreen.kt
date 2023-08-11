package com.example.awesomerates.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.core.CustomCard

@Composable
fun RatesScreen(modifier: Modifier, onActionClick: () -> Unit) {
    CustomCard(
        modifier = modifier,
        hintText = "Rates Screen",
        buttonLabel = "To User screen",
        onButtonClick = onActionClick
    )
}