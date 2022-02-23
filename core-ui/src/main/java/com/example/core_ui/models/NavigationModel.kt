package com.example.core_ui.models

import androidx.navigation.*
import androidx.navigation.fragment.FragmentNavigator

data class NavigationModel(
    val extras: FragmentNavigator.Extras,
    val action: NavDirections
)
