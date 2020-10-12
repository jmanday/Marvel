package com.example.bestbuy.ui.viewholder

import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.bestbuy.R
import com.example.bestbuy.databinding.ViewItemProductBinding
import com.example.core_domain.Product
import com.example.core_ui.viewholder.BaseViewHolder

class ProductViewHolder(private var view: View) : BaseViewHolder<Product>(view) {

    private val binding = ViewItemProductBinding.bind(view)

    override fun onBind(product: Product, f: (product: Product, v: View) -> Unit) {
        binding.ivFav.setOnClickListener {
            product.selected = !product.selected
            val drawable = if (product.selected) ContextCompat.getDrawable(itemView.context, R.drawable.ic_favorite_fill_24)
                            else ContextCompat.getDrawable(itemView.context, R.drawable.ic_favorite_24)
            it.background = drawable
        }
        binding.root.setOnClickListener {
            f(product, it)
        }
        Glide.with(view.context).load(product.image).into(binding.ivProduct)
    }
}