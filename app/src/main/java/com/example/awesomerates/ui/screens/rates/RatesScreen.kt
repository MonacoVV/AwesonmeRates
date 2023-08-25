package com.example.awesomerates.ui.screens.rates

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.core.CustomCard

@Composable
fun RatesScreen(
    modifier: Modifier = Modifier,
    userName: String = "",
    onAuthChanged: (String) -> Unit = {},
    onSaveClicked: (String) -> Unit = {},
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

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = userName,
            onValueChange = onAuthChanged
        )
        CustomCard(
            modifier = modifier,
            hintText = userName,
            buttonLabel = "Do save",
            onButtonClick = { onSaveClicked(userName) }
        )
    }
}


