package com.example.bestbuy.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.*
import androidx.navigation.fragment.FragmentNavigator
import com.google.android.material.appbar.MaterialToolbar

abstract class BaseFragment(resId: Int) : Fragment(resId) {

    protected var mToolBar: MaterialToolbar? = null
    private lateinit var navController: NavController
    //private val navController by lazy { findNavController(this) }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        mToolBar?.let {
            it.setNavigationOnClickListener {
                onNavigationToBack()
            }
        }
    }

    protected fun onNavigationToDestination(actionId: Int) {
        navController.navigate(actionId)
    }

    protected fun onNavigationToBack() {
        navController.navigateUp()
    }

    protected fun onNavigationTo(navDirections: NavDirections, extras: FragmentNavigator.Extras) {
        navController.navigate(navDirections, extras)
    }

    protected fun onNavigationToNavDirections(navDirections: NavDirections) {
        navController.navigate(navDirections)
    }

    protected fun onNavigationToDestinationFromSplash(
        actionId: Int,
        args: Bundle?,
        options: NavOptions
    ) {
        navController.navigate(actionId, args, options)
    }

}