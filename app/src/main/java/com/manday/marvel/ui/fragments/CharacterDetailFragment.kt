package com.manday.marvel.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.manday.marvel.R
import com.manday.marvel.data.models.CharacterEntity
import com.manday.marvel.ui.viewmodels.CharacterDetailViewModel
import com.manday.marvel.ui.viewmodels.CharactersListViewModel
import com.manday.marvel.databinding.FragmentCharacterDetailBinding

class CharacterDetailFragment : BaseFragment(R.layout.fragment_character_detail) {

    private val navArgs: CharacterDetailFragmentArgs by navArgs()

    private val vieModel: CharacterDetailViewModel by viewModels {
        DetailViewModelFactory(navArgs.character)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentCharacterDetailBinding.bind(view)
        binding.characterDetailToolbar.setOnClickListener { findNavController().popBackStack() }
        Glide.with(view.context).load(navArgs.character.thumbnailPath.plus("/portrait_incredible.jpg")).into(binding.characterDetailImage)
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

    /*
    private fun FragmentProductDetailBinding.updateUI(state: ProductDetailViewModel.UIDetailState) {
        productDetailModel = state.product
        tvPrice.paintFlags = state.product?.let {
            tvPrice.paintFlags
        } ?: Paint.STRIKE_THRU_TEXT_FLAG
        mbAdd.isEnabled = state.product?.available ?: false
    }

     */

    companion object {
        val CHARACTER = "CHARACTER"
    }

    class DetailViewModelFactory(val characterEntity: CharacterEntity) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CharacterDetailViewModel(characterEntity) as T
        }
    }

}