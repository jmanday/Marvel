package com.manday.coredata.navigation

import android.view.View
import com.example.core_ui.models.NavigationModel

interface MotionNavigate<T> {

    fun navigate(itemView: View, t: T): NavigationModel
}