package com.example.awesomerates.ui.screens.rates

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.core.CustomCard

@Composable
fun RatesScreen(
    modifier: Modifier = Modifier,
    onActionClick: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        CustomCard(
            modifier = modifier,
            hintText = "Rates Screen",
            buttonLabel = "To User screen",
            onButtonClick = onActionClick
        )
    }
}


