package com.example.bestbuy.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bestbuy.R
import com.example.bestbuy.ui.models.ProductModel
import com.example.bestbuy.ui.viewholder.ProductViewHolder
import com.manday.coreui.adapter.BaseAdapter


class ProductAdapter(listProduct: List<ProductModel>, listener: (ProductModel, View) -> Unit) : BaseAdapter<ProductModel, ProductViewHolder>(listProduct, listener) {

    val load: (listProductLoaded: List<ProductModel>) -> Unit = {
        listT = it
        notifyDataSetChanged()
    }

    override fun generateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.view_item_product, parent, false)

        return ProductViewHolder(v)
    }
}