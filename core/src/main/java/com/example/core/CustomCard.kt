package com.example.core

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
@Preview
fun CustomCard(
    modifier: Modifier = Modifier,
    hintText: String = "Hello",
    buttonLabel: String = "Fire",
    onButtonClick: () -> Unit = {},
) {
    Column(
        modifier = modifier
    ) {
        Row(
            Modifier
                .padding(6.dp)
                .fillMaxWidth()
        ) {
            Text(text = hintText)
            Spacer(modifier = Modifier.weight(1f))
            Image(imageVector = Icons.Filled.MailOutline, contentDescription = "Send hello")
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp), onClick = onButtonClick
        ) {
            Text(text = buttonLabel)
        }
    }
}