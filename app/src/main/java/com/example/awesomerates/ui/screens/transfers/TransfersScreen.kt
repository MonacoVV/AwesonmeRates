package com.example.awesomerates.ui.screens.transfers


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.awesomerates.di.storeViewModel
import com.example.awesomerates.mvi.TransferContainer
import com.example.awesomerates.mvi.TransfersAction
import com.example.awesomerates.mvi.TransfersIntent
import com.example.awesomerates.mvi.TransfersState
import com.example.awesomerates.ui.StyledPreview
import pro.respawn.flowmvi.api.IntentReceiver
import pro.respawn.flowmvi.compose.dsl.subscribe

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
    val snack = remember {
        SnackbarHostState()
    }

    val store = storeViewModel<TransferContainer, _, _, _>()
    val state by store.subscribe { action ->
        when (action) {
            is TransfersAction.ShowMessage -> {
                snack.showSnackbar(message = action.message)
            }
        }
    }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snack)
        }
    ) {
        store.ComposeScreenContent(state = state, modifier = Modifier.padding(it))

    }
}




@Composable
private fun IntentReceiver<TransfersIntent>.ComposeScreenContent(
    state: TransfersState,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (state) {
            is TransfersState.Loading -> CircularProgressIndicator()
            is TransfersState.Error -> Text(state.e.message.toString())
            is TransfersState.DisplayingAmount -> Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Amount: ${state.amount}",
                )
                Text(
                    text = "Transactions count: ${state.transactions}",
                )
                Row() {
                    Button(onClick = { intent(TransfersIntent.Deposit) }) {
                        Text(text = "Deposit")
                    }
                    Button(onClick = { intent(TransfersIntent.Withdrawal) }) {
                        Text(text = "Wichdrawal")
                    }
                }
                Button(onClick = { intent(TransfersIntent.Send) }) {
                    Text(text = "Send")
                }
            }
        }
    }
}
