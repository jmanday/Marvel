package com.manday.marvel.ui.CharacterDetail

import android.os.Bundle
import android.view.View
import androidx.compose.material.MaterialTheme
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.manday.marvel.R
import com.manday.marvel.data.datasource.net.models.CharacterEntity
import com.manday.marvel.ui.viewmodels.CharacterDetailViewModel
import com.manday.marvel.databinding.FragmentCharacterDetailBinding
import com.manday.marvel.ui.fragments.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_character_detail.*

@AndroidEntryPoint
class CharacterDetailFragment : BaseFragment(R.layout.fragment_character_detail) {

    private val navArgs: CharacterDetailFragmentArgs by navArgs()
    private val vieModel: CharacterDetailViewModel by viewModels()
    private val character: CharacterEntity by lazy { navArgs.character }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FragmentCharacterDetailBinding.bind(view)
            .updateUI()
            .apply {
                compose_view.setContent {
                    MaterialTheme {
                        CharacterDetailContent(vieModel, character)
                    }
                }
            }
    }

    private fun FragmentCharacterDetailBinding.updateUI() {
        characterDetailToolbar.setOnClickListener { findNavController().popBackStack() }
        view?.let {
            Glide
                .with(it.context)
                .load(character.thumbnailPath.plus("/landscape_incredible.jpg"))
                .transition(withCrossFade())
                .onlyRetrieveFromCache(true)
                .into(characterDetailImage)

        }

        with(character) {
            characterDetailToolbar.title = name
            //characterDetailDescription.text = description
        }
    }

}