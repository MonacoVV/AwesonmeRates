package com.example.awesomerates.ui.viewmodel

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.awesomerates.domain.state.MainScreenState
import com.example.awesomerates.domain.state.MainScreenStateBuilder

@Stable
class MainViewModel : ViewModel() {
    var state: MainScreenState by mutableStateOf(MainScreenState())
        private set

    fun updateState(block: MainScreenStateBuilder.() -> Unit) {
        val builder =  MainScreenStateBuilder(base = state)
        builder.block()
        state = builder.buildState()
    }
}