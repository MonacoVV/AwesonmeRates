package com.example.awesomerates.navigation

import android.app.Activity
import android.os.Parcelable
import dev.olshevski.navigation.reimagined.NavController
import dev.olshevski.navigation.reimagined.pop
import dev.olshevski.navigation.reimagined.replaceAll
import kotlinx.parcelize.Parcelize

sealed interface ApplicationDestination : Parcelable {

    @Parcelize
    object Rates: ApplicationDestination

    @Parcelize
    object User: ApplicationDestination

    @Parcelize
    object Transfers: ApplicationDestination

    @Parcelize
    data class Credentials(val data: String) : ApplicationDestination
}

fun <T> NavController<T>.topDestination() =
    backstack.entries.lastOrNull()?.destination

context(Activity)
fun NavController<ApplicationDestination>.back() {
    val top = topDestination()

    if (top == ApplicationDestination.Transfers) {
        finish()
    } else if (backstack.entries.size > 1) {
        pop()
    } else {
        replaceAll(ApplicationDestination.Transfers)
    }
}