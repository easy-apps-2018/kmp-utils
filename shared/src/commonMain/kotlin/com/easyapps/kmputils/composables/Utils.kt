package com.easyapps.kmputils.composables

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import com.easyapps.kmputils.utils.EMPTY
import org.jetbrains.compose.resources.PluralStringResource
import org.jetbrains.compose.resources.pluralStringResource

@Composable
fun rememberDrawerState(): DrawerState {
    return rememberDrawerState(initialValue = DrawerValue.Closed)
}

@Composable
fun rememberSavableInt(value: Int = 0): MutableIntState {
    return rememberSaveable { mutableIntStateOf(value) }
}

@Composable
fun rememberSavableFloat(value: Float = 0f): MutableState<Float> {
    return rememberSaveable { mutableStateOf(value) }
}

@Composable
fun pluralResource(resource: PluralStringResource, count: Int): String {
    return pluralStringResource(resource = resource, count, count)
}

@Composable
fun rememberSavableString(value: String = EMPTY): MutableState<String> {
    return rememberSaveable { mutableStateOf(value) }
}

@Composable
fun rememberSavableBoolean(value: Boolean = false): MutableState<Boolean> {
    return rememberSaveable { mutableStateOf(value) }
}