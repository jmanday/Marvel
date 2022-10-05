package com.manday.marvel.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.CreationExtras
import com.manday.marvel.R
import com.manday.marvel.data.models.CharacterEntity
import com.manday.marvel.navigation.NavigateFromProductToDetailFragment
import com.manday.marvel.ui.adapters.CharacterAdapter
import com.manday.marvel.ui.viewmodels.CharactersListViewModel
import com.manday.coredata.navigation.MotionNavigate
import com.manday.marvel.databinding.FragmentCharactersListBinding
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get
import org.koin.java.KoinJavaComponent.inject


class CharactersListFragment : BaseFragment(R.layout.fragment_characters_list) {

    private var adapter = CharacterAdapter()
    private val vieModel: CharactersListViewModel by viewModels()
    private val navigateToDetailFragment: MotionNavigate<CharacterEntity> by inject(
        NavigateFromProductToDetailFragment::class.java
    )

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

    private fun FragmentCharactersListBinding.updateUI(state: CharactersListViewModel.UIProductListState) {
        progress.visibility = if (state.loading) View.VISIBLE else View.GONE
        state.characters?.let { adapter.submitList(it) }
    }


}