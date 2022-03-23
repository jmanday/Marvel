package com.example.bestbuy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import com.example.bestbuy.R
import com.example.bestbuy.databinding.FragmentProductListBinding
import com.example.bestbuy.navigation.NavigateFromProductToDetailFragment
import com.example.bestbuy.ui.adapters.ProductAdapter
import com.example.bestbuy.ui.viewmodels.ProductViewModel
import com.example.core_domain.Product
import com.manday.coredata.navigation.MotionNavigate
import org.koin.java.KoinJavaComponent.inject


class ProductListFragment : BaseFragment() {

    private lateinit var fragmentProductListBinding: FragmentProductListBinding
    private val vieModel: ProductViewModel by lazy {
        ViewModelProvider(this).get(ProductViewModel::class.java)
    }

    private val navigateToDetailFragment: MotionNavigate<Product> by inject(
        NavigateFromProductToDetailFragment::class.java
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        fragmentProductListBinding = FragmentProductListBinding.inflate(inflater)

        return fragmentProductListBinding.root
    }

    override fun initialize() {
        mToolBar = fragmentProductListBinding.toolbar
        //fragmentProductListBinding.productRecyclerView.showShimmer()
        vieModel.products.observe(this) {
            it?.let {
                val adapter = ProductAdapter(it) { product, view ->
                    val (extras, navDirections) = navigateToDetailFragment.navigate(
                        view,
                        product
                    )
                    onNavigationTo(navDirections, extras)
                }
                fragmentProductListBinding.productRecyclerView.adapter = adapter
                //fragmentProductListBinding.productRecyclerView.hideShimmer()
            }
        }
    }
}