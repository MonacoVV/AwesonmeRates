package com.example.awesomerates.navigation


sealed class Screens(val route: String, val name: String = "") {
    object Rates : Screens("rates", "Rates")
    object User : Screens("user", "User")
    object Transfers : Screens("transfers", "Transfers")
    object LoginFlow : Screens("loginFlow") {
        object LoginInfo : Screens("loginInfo")
        object Login : Screens("login")
        object Registration : Screens("registration")
    }
}