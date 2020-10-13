package com.example.core_ui.transitions

import android.content.Context
import androidx.core.content.ContextCompat
import com.google.android.material.transition.platform.MaterialContainerTransform

class ContainerTransformFade : TransitionMode {

    override fun make(context: Context, attributes: TransitionAttributes) =
        MaterialContainerTransform().apply {
            fadeMode = attributes.mode
            duration = attributes.duration
            scrimColor = ContextCompat.getColor(context, attributes.colorScrim)
        }
}