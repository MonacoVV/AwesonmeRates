package com.example.awesomerates.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.awesomerates.ui.theme.AwesomeRatesTheme

@Composable
fun StyledPreview(content: @Composable ColumnScope.() -> Unit = {}) {
    AwesomeRatesTheme {
        Scaffold { paddingValues ->
            Column(Modifier.padding(paddingValues)) {
                content()
            }
        }
    }
}