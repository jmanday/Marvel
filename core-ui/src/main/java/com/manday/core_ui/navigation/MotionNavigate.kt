package com.manday.coredata.navigation

import android.view.View
import com.manday.core_ui.models.NavigationModel

interface MotionNavigate<T> {

    fun navigate(itemView: View, t: T): NavigationModel
}