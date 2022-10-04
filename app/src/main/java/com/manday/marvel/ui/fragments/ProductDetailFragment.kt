package com.manday.marvel.ui.fragments

import android.graphics.Paint
import android.os.Bundle
import android.view.View
import androidx.lifecycle.*
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.manday.marvel.R
import com.manday.marvel.databinding.FragmentProductDetailBinding
import com.manday.marvel.ui.viewmodels.ProductDetailViewModel
import com.manday.core_ui.transitions.ContainerTransformFade
import com.manday.core_ui.transitions.TransitionAttributes
import com.manday.core_ui.transitions.TransitionMode
import com.google.android.material.transition.MaterialContainerTransform
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent

class ProductDetailFragment : BaseFragment(R.layout.fragment_product_detail) {

    private val vieModel: ProductDetailViewModel by lazy {
        ViewModelProvider(this)[ProductDetailViewModel::class.java]
    }
    //private val args: ProductDetailFragmentArgs by navArgs()
    private val transition: TransitionMode by KoinJavaComponent.inject(ContainerTransformFade::class.java)
    private val attributes: TransitionAttributes =
        TransitionAttributes(mode = MaterialContainerTransform.FADE_MODE_CROSS)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = transition.make(requireContext(), attributes)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val binding = FragmentProductDetailBinding.bind(view)
        //vieModel.idProduct = args.product.id ?: 0
        /*
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                vieModel.productState.collect { binding.updateUI(it) }
            }
        }

         */
        //mToolBar = fragmentProductDetailBinding.toolbar
        //binding.root.transitionName = args.transitionName

        /*
        Glide.with(requireContext())
            .load(args.product.imagePath)
            .into(binding.ivProduct)
*/
        //binding.mbAdd.setOnClickListener { vieModel.onAddCartButtonClicked() }
    }

    private fun FragmentProductDetailBinding.updateUI(state: ProductDetailViewModel.UIDetailState) {
        productDetailModel = state.product
        tvPrice.paintFlags = state.product?.let {
            tvPrice.paintFlags
        } ?: Paint.STRIKE_THRU_TEXT_FLAG
        mbAdd.isEnabled = state.product?.available ?: false
    }

}