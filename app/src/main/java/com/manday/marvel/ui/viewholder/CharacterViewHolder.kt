package com.manday.marvel.ui.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.manday.marvel.data.models.CharacterEntity
import com.manday.marvel.databinding.ViewItemCharacterBinding
import com.manday.core_ui.viewholder.BaseViewHolder

class CharacterViewHolder(private var view: View) : BaseViewHolder<CharacterEntity>(view) {

    private val binding = ViewItemCharacterBinding.bind(view)

    override fun onBind(character: CharacterEntity) {
        binding.ivFav.setOnClickListener {
            /*
            product.selected = !product.selected
            val drawable = if (product.selected) ContextCompat.getDrawable(itemView.context, R.drawable.ic_favorite_fill_24)
                            else ContextCompat.getDrawable(itemView.context, R.drawable.ic_favorite_24)
            it.background = drawable

             */
        }
        binding.root.setOnClickListener {
            //f(character, it)
        }

        Glide.with(view.context).load(character.thumbnailPath.plus("/portrait_incredible.jpg")).into(binding.ivCharacter)
    }
}