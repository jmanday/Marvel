package com.manday.core_ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder<T>(itemView: View): RecyclerView.ViewHolder(itemView) {

    open fun onBind(t: T) {}
}