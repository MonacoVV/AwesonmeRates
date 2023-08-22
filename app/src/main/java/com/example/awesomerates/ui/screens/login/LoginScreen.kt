package com.example.awesomerates.ui.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.awesomerates.ui.StyledPreview


@Preview
@Composable
fun LoginScreenPreView() {
    StyledPreview {
        LoginScreen()
    }
}

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onLoginComplete: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        val userName = remember {mutableStateOf("userName") }
        val password = remember {mutableStateOf("password") }
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = userName.value, onValueChange = {
                userName.value = it
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = password.value, onValueChange = {
                password.value = it
            }
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(onClick = onLoginComplete) {
                Text(text = "Login")
            }
        }
    }
}