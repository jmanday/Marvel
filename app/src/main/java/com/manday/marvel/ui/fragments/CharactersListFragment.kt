package com.manday.marvel.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import com.manday.marvel.R
import com.manday.marvel.data.models.CharacterEntity
import com.manday.marvel.navigation.NavigateFromProductToDetailFragment
import com.manday.marvel.ui.adapters.CharacterAdapter
import com.manday.marvel.ui.viewmodels.CharactersListViewModel
import com.manday.coredata.navigation.MotionNavigate
import com.manday.marvel.databinding.FragmentCharactersListBinding
import com.manday.marvel.domain.repository.CharacterResult
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject


class CharactersListFragment : BaseFragment(R.layout.fragment_characters_list) {

    private lateinit var adapter: CharacterAdapter
    private val vieModel: CharactersListViewModel by viewModels()
    private val navigateToDetailFragment: MotionNavigate<CharacterEntity> by inject(
        NavigateFromProductToDetailFragment::class.java
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CharacterAdapter(vieModel::onCharacterClicked)
        val binding = FragmentCharactersListBinding.bind(view).apply {
            charactersRecyclerView.adapter = adapter
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                vieModel.state.collect { binding.updateUI(it) }
            }
        }
    }

    private fun FragmentCharactersListBinding.updateUI(state: CharactersListViewModel.UIProductListState) {
        progress.visibility = if (state.loading) View.VISIBLE else View.GONE
        when (state.characterResult) {
            is CharacterResult.SuccessfullResult -> adapter.submitList(state.characterResult.listCharacterResult)
            is CharacterResult.WrongResult -> adapter.submitList(emptyList())
            else -> {}
        }
        state.navigateTo?.let {
            val navAction = CharactersListFragmentDirections.actionMainToDetail(it)
            findNavController().navigate(navAction)
        }

    }
}