package com.example.bestbuy.ui.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.example.bestbuy.data.models.CharacterEntity
import com.example.bestbuy.databinding.ViewItemCharacterBinding
import com.example.core_ui.viewholder.BaseViewHolder

class CharacterViewHolder(private var view: View) : BaseViewHolder<CharacterEntity>(view) {

    private val binding = ViewItemCharacterBinding.bind(view)

    override fun onBind(character: CharacterEntity, f: (character: CharacterEntity, v: View) -> Unit) {
        binding.ivFav.setOnClickListener {
            /*
            product.selected = !product.selected
            val drawable = if (product.selected) ContextCompat.getDrawable(itemView.context, R.drawable.ic_favorite_fill_24)
                            else ContextCompat.getDrawable(itemView.context, R.drawable.ic_favorite_24)
            it.background = drawable

             */
        }
        binding.root.setOnClickListener {
            f(character, it)
        }

        Glide.with(view.context).load(character.thumbnailPath.plus("/portrait_incredible.jpg")).into(binding.ivCharacter)
    }
}