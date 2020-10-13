package com.example.bestbuy.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.bestbuy.listener.NavigationListener
import com.google.android.material.appbar.MaterialToolbar

abstract class BaseFragment : Fragment() {

    protected lateinit var navigationListener: NavigationListener
    protected var mToolBar: MaterialToolbar? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is NavigationListener)
            navigationListener = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()

        mToolBar?.let {
            it.setNavigationOnClickListener {
                navigationListener.onNavigationToBack()
            }
        }
    }

    protected abstract fun initialize()
}