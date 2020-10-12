package com.example.bestbuy.di

import com.example.bestbuy.data.datasource.ProductDataSource
import com.example.bestbuy.data.datasource.RemoteProductDataSource
import com.example.bestbuy.navigation.NavigateFromProductToDetailFragment
import com.example.bestbuy.repository.ProductRepositoryImpl
import com.example.bestbuy.repository.ProductRepository
import com.example.core_ui.transitions.ContainerTransformFade
import org.koin.dsl.module

val appModuleDependencies = module {

    // Single instances
    single<ProductDataSource> { RemoteProductDataSource() }

    single<ProductRepository> { ProductRepositoryImpl(get()) }

    factory { ContainerTransformFade() }
    factory { NavigateFromProductToDetailFragment() }
}