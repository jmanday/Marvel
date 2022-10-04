package com.manday.marvel.ui.splash

import com.manday.core_data.utils.ExecutorViewModel


class SplashViewModel: ExecutorViewModel() {

    fun load(splashScreen: () -> Unit) {
        waitAndRunInForeground { splashScreen.invoke() }
    }
}