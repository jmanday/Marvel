package com.example.bestbuy.ui.fragments

import android.graphics.Paint
import android.os.Bundle
import android.view.View
import androidx.lifecycle.*
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.bestbuy.R
import com.example.bestbuy.databinding.FragmentProductDetailBinding
import com.example.bestbuy.ui.viewmodels.ProductDetailViewModel
import com.example.core_ui.transitions.ContainerTransformFade
import com.example.core_ui.transitions.TransitionAttributes
import com.example.core_ui.transitions.TransitionMode
import com.google.android.material.transition.MaterialContainerTransform
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent

class ProductDetailFragment : BaseFragment(R.layout.fragment_product_detail) {

    private val vieModel: ProductDetailViewModel by lazy {
        ViewModelProvider(this)[ProductDetailViewModel::class.java]
    }
    private val args: ProductDetailFragmentArgs by navArgs()
    private val transition: TransitionMode by KoinJavaComponent.inject(ContainerTransformFade::class.java)
    private val attributes: TransitionAttributes =
        TransitionAttributes(mode = MaterialContainerTransform.FADE_MODE_CROSS)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = transition.make(requireContext(), attributes)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentProductDetailBinding.bind(view)

        vieModel.idProduct = args.product.id ?: 0
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                vieModel.product.collect { binding.updateUI(it) }
            }
        }
        //mToolBar = fragmentProductDetailBinding.toolbar
        binding.root.transitionName = args.transitionName

        Glide.with(requireContext())
            .load(args.product.image)
            .into(binding.ivProduct)

        binding.mbAdd.setOnClickListener { vieModel.onAddCartButtonClicked() }
    }

    private fun FragmentProductDetailBinding.updateUI(state: ProductDetailViewModel.UIDetailState) {
        product = state.product
        tvPrice.paintFlags = if (state.discount) tvPrice.paintFlags else Paint.STRIKE_THRU_TEXT_FLAG
        mbAdd.isEnabled = state.available
    }
}