package com.example.bestbuy.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bestbuy.databinding.FragmentProductListBinding
import com.example.bestbuy.ui.viewmodels.ProductViewModel


class ProductListFragment : BaseFragment() {

    private lateinit var fragmentProductListBinding: FragmentProductListBinding
    private val vieModel: ProductViewModel by lazy {
        ViewModelProvider(this).get(ProductViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentProductListBinding = FragmentProductListBinding.inflate(inflater)

        return fragmentProductListBinding.root
    }

    override fun initialize() {
        vieModel.getProducts()?.observe(this, Observer {
            it?.let {

            }
        })
        fragmentProductListBinding.productRecyclerView.showShimmer()
    }
}