package com.example.bestbuy.navigation

import android.view.View
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.example.bestbuy.Constants.NAME_GENERAL_TRANSITION
import com.example.bestbuy.ui.fragments.ProductListFragmentDirections
import com.example.core_domain.Product
import com.example.core_ui.models.NavigationModel
import com.manday.coredata.navigation.MotionNavigate

internal class NavigateFromProductToDetailFragment : MotionNavigate<Product> {

    override fun navigate(itemView: View, product: Product): NavigationModel {
        itemView.transitionName = itemView.transitionName ?: NAME_GENERAL_TRANSITION
        val extras = FragmentNavigatorExtras(itemView to itemView.transitionName)
        val action = ProductListFragmentDirections.actionProductListFragmentToProductDetailFragment(
            product,
            itemView.transitionName
        )

        return NavigationModel(extras, action)
    }

}