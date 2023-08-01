package com.example.core

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
@Preview
fun CustomCard(modifier: Modifier = Modifier, text: String = "Hello") {
    Row(
        modifier.padding(6.dp)
    ) {
        Text(text = text)
        Image(imageVector = Icons.Filled.MailOutline, contentDescription = "Send hello")
    }
}