package com.manday.marvel.ui.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.manday.marvel.data.datasource.net.models.CharacterEntity
import com.manday.marvel.databinding.ViewItemCharacterBinding
import com.manday.core_ui.viewholder.BaseViewHolder

class CharacterViewHolder(
    private var view: View,
    private val listener: (CharacterEntity) -> Unit) : BaseViewHolder<CharacterEntity>(view) {

    private val binding = ViewItemCharacterBinding.bind(view)

    override fun onBind(character: CharacterEntity) {

        binding.root.setOnClickListener {
            listener(character)
        }

        Glide
            .with(view.context)
            .load(character.thumbnailPath.plus("/portrait_incredible.jpg"))
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .into(binding.ivCharacter)
    }
}