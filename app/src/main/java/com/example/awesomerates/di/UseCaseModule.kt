package com.example.awesomerates.di

import androidx.compose.runtime.Composable
import com.example.awesomerates.domain.GetAuthorizedStateUseCase
import com.example.awesomerates.mvi.TransferContainer
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module
import pro.respawn.flowmvi.android.StoreViewModel
import pro.respawn.flowmvi.api.Container
import pro.respawn.flowmvi.api.MVIAction
import pro.respawn.flowmvi.api.MVIIntent
import pro.respawn.flowmvi.api.MVIState

val useCaseModule = module {
    single { GetAuthorizedStateUseCase(get()) }
    factoryOf(::TransferContainer)
    storeViewModel<TransferContainer>()
}

inline fun <reified T : Container<*, *, *>> Module.storeViewModel() {
    viewModel(qualifier<T>()) { params ->
        StoreViewModel(get<T> { params })
    }
}
@Composable
inline fun <reified T : Container<S, I, A>, S : MVIState, I : MVIIntent, A : MVIAction> storeViewModel(
    noinline params: ParametersDefinition? = null,
) = getViewModel<StoreViewModel<S, I, A>>(qualifier<T>(), parameters = params)