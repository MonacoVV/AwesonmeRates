package com.example.awesomerates.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.awesomerates.domain.User
import java.util.concurrent.atomic.AtomicInteger

@Stable
class UserViewModel(
    private val user: User
) : ViewModel()  {

    private val cnt = getCounter()

    init {
        Log.d("UserViewModel", "Created, sequence $cnt")
    }

    companion object {
        private val counter = AtomicInteger(0)
        private fun getCounter(): Int {
            return counter.incrementAndGet()
        }
    }
    var userName : String by mutableStateOf(user.name + cnt)
        private set
}