package com.example.bestbuy.navigation

import android.view.View
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.example.bestbuy.Constants.NAME_GENERAL_TRANSITION
import com.example.bestbuy.data.models.CharacterEntity
import com.example.bestbuy.ui.fragments.CharactersListFragmentDirections
import com.example.bestbuy.ui.models.ProductModel
import com.example.core_ui.models.NavigationModel
import com.manday.coredata.navigation.MotionNavigate

internal class NavigateFromProductToDetailFragment

    /*: MotionNavigate<CharacterEntity> {

    override fun navigate(itemView: View, character: CharacterEntity): NavigationModel {
        itemView.transitionName = itemView.transitionName ?: NAME_GENERAL_TRANSITION
        val extras = FragmentNavigatorExtras(itemView to itemView.transitionName)
        /*
        val action = CharactersListFragmentDirections.actionProductListFragmentToProductDetailFragment(
            character,
            itemView.transitionName
        )
        */
        return NavigationModel(extras, action)
    }

}*/