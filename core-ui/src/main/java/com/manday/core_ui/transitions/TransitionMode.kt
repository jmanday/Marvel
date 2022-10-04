package com.manday.core_ui.transitions

import android.content.Context
import android.transition.Transition

interface TransitionMode {

    fun make(context: Context, transitionAttributes: TransitionAttributes): Transition
}