package com.example.bestbuy.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bestbuy.R
import com.example.bestbuy.data.models.CharacterEntity
import com.example.bestbuy.ui.models.ProductModel
import com.example.bestbuy.ui.viewholder.CharacterViewHolder
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