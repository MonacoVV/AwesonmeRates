package com.example.awesomerates.mvi

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import pro.respawn.flowmvi.api.ActionShareBehavior
import pro.respawn.flowmvi.api.Container
import pro.respawn.flowmvi.api.MVIAction
import pro.respawn.flowmvi.api.MVIIntent
import pro.respawn.flowmvi.api.MVIState
import pro.respawn.flowmvi.dsl.store
import pro.respawn.flowmvi.dsl.updateState
import pro.respawn.flowmvi.plugins.init
import pro.respawn.flowmvi.plugins.platformLoggingPlugin
import pro.respawn.flowmvi.plugins.recover
import pro.respawn.flowmvi.plugins.reduce
import pro.respawn.flowmvi.util.typed
import pro.respawn.flowmvi.util.withType
import kotlin.random.Random

sealed interface TransfersState : MVIState {
    data object Loading : TransfersState
    data class Error(val e: Exception) : TransfersState

    data class DisplayingAmount(
        val transactions: Int,
        val amount: Int,
    ) : TransfersState
}


sealed interface TransfersIntent : MVIIntent {
    data object Deposit : TransfersIntent
    data object Withdrawal : TransfersIntent
    data object Send : TransfersIntent
}

sealed interface TransfersAction : MVIAction {
    data class ShowMessage(val message: String) : TransfersAction
}

class TransferContainer : Container<TransfersState, TransfersIntent, TransfersAction> {
    override val store = store(initial = TransfersState.Loading) {
        name = "CounterStore"
        parallelIntents = true
        coroutineContext =
            Dispatchers.Default // run all operations on background threads if needed
        actionShareBehavior =
            ActionShareBehavior.Distribute() // disable, share, distribute or consume side effects
        intentCapacity = 64


        init {
            delay(1000)
            updateState{
                TransfersState.DisplayingAmount(0, 0)
            }
        }

        install(
            platformLoggingPlugin()
        )

        recover { e: Exception ->
            action(TransfersAction.ShowMessage("Error occurred ${e.message}"))
            null
        }

        reduce { intent -> // reduce intents
            when (intent) {
                TransfersIntent.Deposit -> updateState<TransfersState.DisplayingAmount, _> {
                    copy(
                        amount = amount + 100,
                        transactions = transactions + 1
                    )
                }
                TransfersIntent.Withdrawal -> updateState<TransfersState.DisplayingAmount, _> {
                    copy(
                        amount = (amount - 100).coerceAtLeast(0),
                        transactions = transactions + 1
                    )
                }
                TransfersIntent.Send -> {
                    updateState<TransfersState.DisplayingAmount, _> {
                        action(TransfersAction.ShowMessage("Money sent, $amount $$$"))
                        copy(
                            amount = 0,
                            transactions = 0
                        )
                    }
                }
            }
            withState {
                val state = typed<TransfersState.DisplayingAmount>() ?: return@withState
                if (state.amount == 1500) {
                    intent(TransfersIntent.Send)
                }
            }
        }
    }
}