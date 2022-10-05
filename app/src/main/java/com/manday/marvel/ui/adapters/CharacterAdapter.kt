package com.manday.marvel.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.manday.core_ui.adapter.BaseListAdapter
import com.manday.marvel.R
import com.manday.marvel.data.models.CharacterEntity
import com.manday.marvel.ui.viewholder.CharacterViewHolder
import com.manday.marvel.ui.viewholder.CharacterDiffCallback


class CharacterAdapter : BaseListAdapter<CharacterEntity, CharacterViewHolder>(CharacterDiffCallback()) {

    override fun generateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.view_item_character, parent, false)

        return CharacterViewHolder(v)
    }
}