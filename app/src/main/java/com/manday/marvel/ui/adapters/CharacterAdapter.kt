package com.manday.marvel.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.manday.marvel.R
import com.manday.marvel.data.models.CharacterEntity
import com.manday.marvel.ui.viewholder.CharacterViewHolder
import com.manday.coreui.adapter.BaseAdapter


class CharacterAdapter(listCharacters: List<CharacterEntity>, listener: (CharacterEntity, View) -> Unit) : BaseAdapter<CharacterEntity, CharacterViewHolder>(listCharacters, listener) {

    val load: (listCharactersLoaded: List<CharacterEntity>) -> Unit = {
        listT = it
        notifyDataSetChanged()
    }

    override fun generateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.view_item_character, parent, false)

        return CharacterViewHolder(v)
    }
}