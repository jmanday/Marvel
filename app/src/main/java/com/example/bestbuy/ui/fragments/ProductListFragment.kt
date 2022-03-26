package com.example.bestbuy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject


class ProductListFragment : BaseFragment() {

    private lateinit var fragmentProductListBinding: FragmentProductListBinding
    private var adapter: ProductAdapter
    private val vieModel: ProductViewModel by lazy {
        ViewModelProvider(this).get(ProductViewModel::class.java)
    }

    private val navigateToDetailFragment: MotionNavigate<Product> by inject(
        NavigateFromProductToDetailFragment::class.java
    )

    init {
        adapter = ProductAdapter(emptyList()) { product, view ->
            val (extras, navDirections) = navigateToDetailFragment.navigate(
                view,
                product
            )
            onNavigationTo(navDirections, extras)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        fragmentProductListBinding = FragmentProductListBinding.inflate(inflater)
        fragmentProductListBinding.productRecyclerView.adapter = adapter

        return fragmentProductListBinding.root
    }

    override fun initialize() {
        mToolBar = fragmentProductListBinding.toolbar
        vieModel.products.observe(this) {
            fragmentProductListBinding.progress.visibility = View.GONE
            adapter.load(it as ArrayList<Product>)
        }
    }
}