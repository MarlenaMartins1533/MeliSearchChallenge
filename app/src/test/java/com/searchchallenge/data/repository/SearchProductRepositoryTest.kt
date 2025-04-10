package com.searchchallenge.data.repository

import com.searchchallenge.data.dataresources.Resources
import com.searchchallenge.data.remote.datasource.ISearchProductDataSource
import com.searchchallenge.domain.repository.ISearchProductRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class SearchProductRepositoryTest {

    private val apiService: ISearchProductDataSource = mockk()
    private val searchProductRepository: ISearchProductRepository =
        SearchProductRepository(apiService)

    @Test
    fun `get product from api returns success`() = runBlocking {
        //given
        coEvery {
            apiService.searchProducts(Resources.Query)
        } returns Resources.productResponseListParameterProvider

        //when
        val productResponse = searchProductRepository.searchProducts(Resources.Query)

        //then
        assertEquals(productResponse.size, Resources.productResponseListParameterProvider.size)
        assertEquals(
            productResponse.first().productName,
            Resources.productResponseListParameterProvider.first().productName
        )
    }

    @Test
    fun `get product from api returns error`() = runBlocking {
        // TO..DO
    }

}