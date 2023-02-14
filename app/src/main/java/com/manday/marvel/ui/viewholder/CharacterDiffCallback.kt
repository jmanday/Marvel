package com.manday.marvel.ui.viewholder

import androidx.recyclerview.widget.DiffUtil
import com.manday.marvel.data.datasource.net.models.CharacterEntity

open class CharacterDiffCallback : DiffUtil.ItemCallback<CharacterEntity>() {

    override fun areItemsTheSame(oldItem: CharacterEntity, newItem: CharacterEntity): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: CharacterEntity, newItem: CharacterEntity): Boolean {
        return oldItem == newItem
    }

}