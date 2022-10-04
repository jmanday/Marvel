package com.example.bestbuy.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.lifecycle.*
import com.example.bestbuy.R
import com.example.bestbuy.data.models.CharacterEntity
import com.example.bestbuy.databinding.FragmentCharactersListBinding
import com.example.bestbuy.navigation.NavigateFromProductToDetailFragment
import com.example.bestbuy.ui.adapters.CharacterAdapter
import com.example.bestbuy.ui.models.ProductModel
import com.example.bestbuy.ui.viewmodels.ProductListViewModel
import com.manday.coredata.navigation.MotionNavigate
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject


class CharactersListFragment : BaseFragment(R.layout.fragment_characters_list) {

    private var adapter: CharacterAdapter
    /*
    private val vieModel: ProductViewModel by viewModels {
        ProductViewModelFactory()
    }
     */

    private val vieModel: ProductListViewModel by lazy {
        ViewModelProvider(this)[ProductListViewModel::class.java]
    }

    private val navigateToDetailFragment: MotionNavigate<CharacterEntity> by inject(
        NavigateFromProductToDetailFragment::class.java
    )

    init {
        adapter = CharacterAdapter(emptyList()) { character, view ->
            val (extras, navDirections) = navigateToDetailFragment.navigate(
                view,
                character
            )
            onNavigationTo(navDirections, extras)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentCharactersListBinding.bind(view)
        binding.productRecyclerView.adapter = adapter

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                vieModel.productListState.collect { binding.updateUI(it) }
            }
        }
    }



    private fun FragmentCharactersListBinding.updateUI(state: ProductListViewModel.UIProductListState) {
        progress.visibility = if (state.loading) View.VISIBLE else View.GONE
        state.character?.let { adapter.load(it) }
    }
}