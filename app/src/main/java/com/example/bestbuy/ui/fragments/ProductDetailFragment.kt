package com.example.bestbuy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.bestbuy.databinding.FragmentProductDetailBinding
import com.example.core_ui.transitions.ContainerTransformFade
import com.example.core_ui.transitions.TransitionAttributes
import com.example.core_ui.transitions.TransitionMode
import com.google.android.material.transition.MaterialContainerTransform
import org.koin.java.KoinJavaComponent

class ProductDetailFragment : BaseFragment() {

    private lateinit var fragmentProductDetailBinding: FragmentProductDetailBinding
    private val args: ProductDetailFragmentArgs by navArgs()
    private val transition: TransitionMode by KoinJavaComponent.inject(ContainerTransformFade::class.java)
    private val attributes: TransitionAttributes =
        TransitionAttributes(mode = MaterialContainerTransform.FADE_MODE_CROSS)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = transition.make(requireContext(), attributes)
    }

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
        fragmentProductDetailBinding.root.transitionName = args.transitionName

        Glide.with(requireContext())
            .load(args.product.image)
            .into(fragmentProductDetailBinding.ivProduct)
    }

}