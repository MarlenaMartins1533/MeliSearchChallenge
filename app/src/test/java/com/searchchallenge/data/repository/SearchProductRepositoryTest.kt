package com.searchchallenge.data.repository

import com.searchchallenge.Resources
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
    fun `search product from api returns success`() = runBlocking {
        //given
        coEvery {
            apiService.searchProducts(Resources.Query)
        } returns Resources.productDomainListParameterProvider

        //when
        val productResponse = searchProductRepository.searchProducts(Resources.Query)

        //then
        assertEquals(productResponse.size, Resources.productDomainListParameterProvider.size)
        assertEquals(
            productResponse.first().productName,
            Resources.productDomainListParameterProvider.first().productName
        )
    }

    @Test
    fun `search product from api returns error`() = runBlocking {
        // TO..DO
    }
}
