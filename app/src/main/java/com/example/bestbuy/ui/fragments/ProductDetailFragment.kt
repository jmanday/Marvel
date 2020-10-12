package com.example.bestbuy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.bestbuy.databinding.FragmentProductDetailBinding

class ProductDetailFragment : BaseFragment() {

    private lateinit var fragmentProductDetailBinding: FragmentProductDetailBinding
    private val args: ProductDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentProductDetailBinding = FragmentProductDetailBinding.inflate(layoutInflater)
        return fragmentProductDetailBinding.root
    }

    override fun initialize() {
        mToolBar = fragmentProductDetailBinding.toolbar
        fragmentProductDetailBinding.product = args.product
        Glide.with(requireContext())
            .load(args.product.image)
            .into(fragmentProductDetailBinding.imgMain)
    }

}