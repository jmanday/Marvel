package com.example.bestbuy.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.lifecycle.*
import com.example.bestbuy.R
import com.example.bestbuy.databinding.FragmentProductListBinding
import com.example.bestbuy.navigation.NavigateFromProductToDetailFragment
import com.example.bestbuy.ui.adapters.ProductAdapter
import com.example.bestbuy.ui.models.ProductModel
import com.example.bestbuy.ui.viewmodels.ProductListViewModel
import com.manday.coredata.navigation.MotionNavigate
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject


class ProductListFragment : BaseFragment(R.layout.fragment_product_list) {

    private var adapter: ProductAdapter
    /*
    private val vieModel: ProductViewModel by viewModels {
        ProductViewModelFactory()
    }
     */

    private val vieModel: ProductListViewModel by lazy {
        ViewModelProvider(this).get(ProductListViewModel::class.java)
    }

    private val navigateToDetailFragment: MotionNavigate<ProductModel> by inject(
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentProductListBinding.bind(view)
        binding.productRecyclerView.adapter = adapter

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                vieModel.productListState.collect { binding.updateUI(it) }
            }
        }
    }



    private fun FragmentProductListBinding.updateUI(state: ProductListViewModel.UIProductListState) {
        progress.visibility = if (state.loading) View.VISIBLE else View.GONE
        state.products?.let { adapter.load(it) }
    }
}