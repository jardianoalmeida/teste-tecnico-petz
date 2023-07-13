package com.jardiano.petz.ui.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.gson.Gson
import com.jardiano.petz.domain.entity.HearthStone
import com.jardiano.petz.ui.pages.details.DetailScreen
import com.jardiano.petz.ui.pages.home.HomeScreen
import com.jardiano.petz.ui.pages.splash.SplashScreen
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavigation() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
    ) {
        composable(route = Screen.SplashScreen.route,
            enterTransition = {
                tabEnterTransition(AnimatedContentScope.SlideDirection.Start)
            },
            exitTransition = {
                tabExitTransition(AnimatedContentScope.SlideDirection.End)
            }
        ) {
            SplashScreen(
                onFinish = {
                    navController.navigate(Screen.HomeScreen.route)
                }
            )
        }

        composable(route = Screen.HomeScreen.route,
            enterTransition = {
                tabEnterTransition(AnimatedContentScope.SlideDirection.Start)
            },
            exitTransition = {
                tabExitTransition(AnimatedContentScope.SlideDirection.End)
            }
        ) {
            HomeScreen(
                homeViewModel = hiltViewModel(),
                goToDetails = {
                    val model: HearthStone = it
                    var encodedUrlImage: String = ""
                    if (model.image != null)
                        encodedUrlImage =
                            URLEncoder.encode(model.image, StandardCharsets.UTF_8.toString())


                    navController.navigate(Screen.DetailsScreen.route(model.copy(image = encodedUrlImage)))
                }
            )
        }

        composable(route = Screen.DetailsScreen.route,
            enterTransition = {
                tabEnterTransition(AnimatedContentScope.SlideDirection.Start)
            },
            exitTransition = {
                tabExitTransition(AnimatedContentScope.SlideDirection.End)
            }
        ) {
            val modelString = it.arguments?.getString(Screen.DetailsScreen.ARG)
            val model = Gson().fromJson(modelString, HearthStone::class.java)
            DetailScreen(hearthStone = model, onBackPressed = { navController.navigateUp() })
        }


    }
}

@OptIn(ExperimentalAnimationApi::class)
private fun AnimatedContentScope<NavBackStackEntry>.tabExitTransition(
    slideDirection: AnimatedContentScope.SlideDirection,
    duration: Int = 500
) = fadeOut(tween(duration / 2, easing = LinearEasing)) + slideOutOfContainer(
    slideDirection,
    tween(duration, easing = LinearEasing),
    targetOffset = { it / 24 }
)

@OptIn(ExperimentalAnimationApi::class)
private fun AnimatedContentScope<NavBackStackEntry>.tabEnterTransition(
    slideDirection: AnimatedContentScope.SlideDirection,
    duration: Int = 500,
    delay: Int = duration - 350
) = fadeIn(tween(duration, duration - delay)) + slideIntoContainer(
    slideDirection,
    animationSpec = tween(duration, duration - delay),
    initialOffset = { it / 24 }
)