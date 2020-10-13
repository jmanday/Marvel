package com.example.bestbuy.listener

import android.os.Bundle
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions

interface NavigationListener {

    fun onNavigationToDestination(actionId: Int)

    fun onNavigationToDestinationFromSplash(actionId: Int, args: Bundle?, options: NavOptions)

    fun onNavigationToNavDirections(navDirections: NavDirections)

    fun onNavigationToBack()
}