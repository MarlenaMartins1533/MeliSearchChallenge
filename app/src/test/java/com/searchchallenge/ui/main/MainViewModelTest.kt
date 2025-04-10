package com.searchchallenge.ui.main

import com.searchchallenge.Resources
import com.searchchallenge.domain.usecase.SearchProductUseCase
import com.searchchallenge.ui.composable.mapper.DomainToProductMapper
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    private val useCase: SearchProductUseCase = mockk()
    private val mapper: DomainToProductMapper = mockk()
    private val mainViewModel: MainViewModel = MainViewModel(useCase, mapper)

    @Before
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `searchProducts returns success`() = runTest {
        //given
        val itemMovieListExpected = Resources.productListParameterProvider
        coEvery { useCase.invoke(Resources.Query) } returns Resources.productDomainListParameterProvider
        every {
            mapper.invoke(Resources.productDomainListParameterProvider)
        } returns Resources.productListParameterProvider

        //when
        mainViewModel.searchProducts(Resources.Query)

        //then
        assertEquals(
            Resources.productDomainListParameterProvider,
            mainViewModel.searchProductData.value.first()
        )
    }

    @Test
    fun `fetch movies returns error`() = runTest {
        // TO..DO Futuro
    }
}
