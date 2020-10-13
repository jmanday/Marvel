package com.example.bestbuy.ui.fragments

import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.bestbuy.R
import com.example.bestbuy.databinding.FragmentProductDetailBinding
import com.example.bestbuy.ui.viewmodels.ProductDetailViewModel
import com.example.core_ui.transitions.ContainerTransformFade
import com.example.core_ui.transitions.TransitionAttributes
import com.example.core_ui.transitions.TransitionMode
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.transition.MaterialContainerTransform
import org.koin.java.KoinJavaComponent

class ProductDetailFragment : BaseFragment() {

    private lateinit var fragmentProductDetailBinding: FragmentProductDetailBinding
    private val vieModel: ProductDetailViewModel by lazy {
        ViewModelProvider(this).get(ProductDetailViewModel::class.java)
    }
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
        vieModel.thereIsStock.observe(viewLifecycleOwner, Observer {
            if (it) {
                Snackbar.make(fragmentProductDetailBinding.root, R.string.text_stock, Snackbar.LENGTH_SHORT)
                    .show()
            }
            else {
                Toast.makeText(requireContext(), "No quedan existencias", Toast.LENGTH_LONG).show()
            }
        })
        vieModel.idProduct = args.product.id ?: 0
        vieModel.product.observe(viewLifecycleOwner, Observer {
            if (it == null) {
                Toast.makeText(
                    requireContext(),
                    "No se han podido recuperar los datos del producto",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                fragmentProductDetailBinding.product = it
                it.discountPrice?.let {
                    fragmentProductDetailBinding.tvPrice.setPaintFlags(fragmentProductDetailBinding.tvPrice.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
                }
            }
        })
        mToolBar = fragmentProductDetailBinding.toolbar
        fragmentProductDetailBinding.root.transitionName = args.transitionName

        Glide.with(requireContext())
            .load(args.product.image)
            .into(fragmentProductDetailBinding.ivProduct)

        fragmentProductDetailBinding.mbAdd.setOnClickListener { vieModel.onAddCartButtonClicked() }
    }

}