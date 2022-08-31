package com.example.bestbuy.ui.viewmodels

import androidx.lifecycle.Observer
import com.example.bestbuy.domain.repository.ProductRepository
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


class ProductDetailViewModelTest {

    @Mock
    var repositoyy: ProductRepository? = null

    @Mock
    private var viewModel: ProductDetailViewModel? = null

    @Mock
    var observer: Observer<Boolean>? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = ProductDetailViewModel()

        //observer?.let { viewModel?.thereIsStock?.observeForever(it) }
    }

    @Test
    fun `when there is not stock for a product`() {
        `when`(viewModel?.onAddCartButtonClicked()).thenReturn(observer?.onChanged(false))

        verify(observer)?.onChanged(false)
    }

    @Test
    fun `when there is stock for a product`() {
        `when`(viewModel?.onAddCartButtonClicked()).thenReturn(observer?.onChanged(true))

        verify(observer)?.onChanged(true)
    }
}