package com.example.bestbuy.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import com.example.bestbuy.R
import com.example.bestbuy.databinding.FragmentSplashBinding
import com.example.bestbuy.ui.fragments.BaseFragment


class SplashFragment : BaseFragment(R.layout.fragment_splash) {

    private val vieModel: SplashViewModel by lazy {
        ViewModelProvider(this)[SplashViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return FragmentSplashBinding.inflate(inflater).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vieModel.load {
            onNavigationToDestinationFromSplash(R.id.action_splashFragment_to_productListFragment, null,
                NavOptions.Builder()
                    .setPopUpTo(R.id.splashFragment, true)
                    .build())
        }
    }

}