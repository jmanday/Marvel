package com.example.bestbuy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import com.example.bestbuy.R
import com.example.bestbuy.databinding.FragmentSplashBinding
import java.util.*

const val SPLASH_DELAY = 3000L

class SplashFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return FragmentSplashBinding.inflate(inflater).root
    }

    override fun initialize() {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                onNavigationToDestinationFromSplash(R.id.action_splashFragment_to_productListFragment, null,
                    NavOptions.Builder()
                        .setPopUpTo(R.id.splashFragment, true)
                        .build())
            }
        }, SPLASH_DELAY)
    }

}