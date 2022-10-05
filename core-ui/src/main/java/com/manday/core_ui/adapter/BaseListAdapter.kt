package com.manday.core_ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.manday.core_ui.viewholder.BaseViewHolder

abstract class BaseListAdapter<T : Any, VH: BaseViewHolder<T>>(diffCallback: DiffUtil.ItemCallback<T>): ListAdapter<T, VH>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return generateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(getItem(position))
    }

    abstract fun generateViewHolder(parent: ViewGroup, viewType: Int): VH
}