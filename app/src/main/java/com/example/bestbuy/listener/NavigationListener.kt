package com.example.bestbuy.listener

import androidx.navigation.NavDirections

interface NavigationListener {

    fun onNavigationToDestination(actionId: Int)

    fun onNavigationToNavDirections(navDirections: NavDirections)

    fun onNavigationToBack()
}