package com.example.bestbuy.ui.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import com.example.bestbuy.R
import com.example.bestbuy.databinding.FragmentSplashBinding
import java.util.*


class SplashFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return FragmentSplashBinding.inflate(inflater).root
    }

    override fun initialize() {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                navigationListener.onNavigationToDestinationFromSplash(R.id.action_splashFragment_to_productListFragment, null,
                    NavOptions.Builder()
                        .setPopUpTo(R.id.splashFragment, true)
                        .build())
            }
        }, 3000)
    }

}