package com.manday.marvel.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.lifecycle.*
import com.manday.marvel.R
import com.manday.marvel.data.models.CharacterEntity
import com.manday.marvel.navigation.NavigateFromProductToDetailFragment
import com.manday.marvel.ui.adapters.CharacterAdapter
import com.manday.marvel.ui.viewmodels.ProductListViewModel
import com.manday.coredata.navigation.MotionNavigate
import com.manday.marvel.databinding.FragmentCharactersListBinding
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