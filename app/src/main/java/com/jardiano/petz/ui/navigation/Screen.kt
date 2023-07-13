package com.jardiano.petz.ui.navigation

import com.google.gson.Gson
import com.jardiano.petz.domain.entity.HearthStone

sealed class Screen(val route: String) {
    object SplashScreen : Screen(route = "splash")
    object HomeScreen : Screen(route = "home")
    object DetailsScreen : Screen(route = "details/{model}") {
        const val ARG = "model"
        fun route(model: HearthStone): String {
            val modelString = Gson().toJson(model)
            return "details/$modelString"
        }
    }
}