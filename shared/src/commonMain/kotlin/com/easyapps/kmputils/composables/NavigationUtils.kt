package com.easyapps.kmputils.composables

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.runtime.*
import androidx.navigation.*
import androidx.navigation.compose.*

fun NavController.onNavigate(route: String) {
    this.navigate(route) {
        popUpTo(this@onNavigate.graph.startDestinationId) {
            this.inclusive = true
        }
        this.launchSingleTop = true
    }
}

fun onExitScaleOut(duration: Int = 300): ExitTransition {
    return scaleOut(animationSpec = tween(duration))
}

fun onEnterScaleIn(duration: Int = 300): EnterTransition {
    return scaleIn(animationSpec = tween(duration))
}

@Composable
fun rememberNavController(onChanged: (String) -> Unit): NavHostController {
    val controller = rememberNavController()
    controller.addOnDestinationChangedListener { _, destination, _ ->
        onChanged.invoke(destination.route.toString())
    }
    return controller
}

fun AnimatedContentTransitionScope<NavBackStackEntry>.onTarget(): String? {
    return this.targetState.destination.route
}

fun AnimatedContentTransitionScope<NavBackStackEntry>.onInitial(): String? {
    return this.initialState.destination.route
}

fun AnimatedContentTransitionScope<NavBackStackEntry>.onExitDown(duration: Int = 300): ExitTransition {
    return this.slideOutOfContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Down,
        animationSpec = tween(duration)
    )
}

fun AnimatedContentTransitionScope<NavBackStackEntry>.onEnterUp(duration: Int = 300): EnterTransition {
    return slideIntoContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Up, animationSpec = tween(duration)
    )
}

fun AnimatedContentTransitionScope<NavBackStackEntry>.onExitLeft(duration: Int = 300): ExitTransition {
    return slideOutOfContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Left,
        animationSpec = tween(duration)
    )
}

fun AnimatedContentTransitionScope<NavBackStackEntry>.onExitRight(duration: Int = 300): ExitTransition {
    return slideOutOfContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Right,
        animationSpec = tween(duration)
    )
}

fun AnimatedContentTransitionScope<NavBackStackEntry>.onEnterLeft(duration: Int = 300): EnterTransition {
    return slideIntoContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Left,
        animationSpec = tween(duration)
    )
}

fun AnimatedContentTransitionScope<NavBackStackEntry>.onEnterRight(duration: Int = 300): EnterTransition {
    return slideIntoContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Right,
        animationSpec = tween(duration)
    )
}