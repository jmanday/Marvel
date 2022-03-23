package com.example.bestbuy.ui.viewmodels

import com.example.core_data.utils.ExecutorViewModel


class SplashViewModel: ExecutorViewModel() {

    fun load(splashScreen: () -> Unit) {
        waitAndRunInForeground { splashScreen.invoke() }
    }
}