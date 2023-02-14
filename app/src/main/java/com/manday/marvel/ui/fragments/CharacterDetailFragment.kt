package com.manday.marvel.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.manday.marvel.R
import com.manday.marvel.data.datasource.net.models.CharacterEntity
import com.manday.marvel.ui.viewmodels.CharacterDetailViewModel
import com.manday.marvel.ui.viewmodels.CharactersListViewModel
import com.manday.marvel.databinding.FragmentCharacterDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailFragment : BaseFragment(R.layout.fragment_character_detail) {

    private val navArgs: CharacterDetailFragmentArgs by navArgs()

    private val vieModel: CharacterDetailViewModel by viewModels()

    private val character: CharacterEntity by lazy { navArgs.character }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentCharacterDetailBinding.bind(view)
            .updateUI()
    }

    private fun FragmentCharacterDetailBinding.updateUI() {
        characterDetailToolbar.setOnClickListener { findNavController().popBackStack() }
        view?.let { Glide.with(it.context).load(character.thumbnailPath.plus("/landscape_incredible.jpg")).into(characterDetailImage) }
        with(character) {
            characterDetailToolbar.title = name
            characterDetailDescription.text = character.description
        }
    }

}