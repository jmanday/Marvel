package com.example.bestbuy.ui.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.example.bestbuy.databinding.ViewItemProductBinding
import com.example.core_domain.Product
import com.example.core_ui.viewholder.BaseViewHolder

class ProductViewHolder(private var view: View) : BaseViewHolder<Product>(view) {

    private val binding = ViewItemProductBinding.bind(view)

    override fun onBind(product: Product, f: (product: Product, v: View) -> Unit) {
        binding.root.setOnClickListener {
            f(product, it)
        }
        Glide.with(view.context).load(product.image).into(binding.ivProduct)
    }
}