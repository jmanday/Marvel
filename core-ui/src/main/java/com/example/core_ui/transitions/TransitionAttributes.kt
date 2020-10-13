package com.example.core_ui.transitions

import com.example.core_ui.R

data class TransitionAttributes(
    var mode: Int = 0,
    var colorScrim: Int = R.color.colorTransparent,
    var duration: Long = 500
)