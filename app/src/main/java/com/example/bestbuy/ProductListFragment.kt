package com.example.bestbuy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bestbuy.databinding.FragmentProductListBinding


class ProductListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return FragmentProductListBinding.inflate(inflater).root
    }
}