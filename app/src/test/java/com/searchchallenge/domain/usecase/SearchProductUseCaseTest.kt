package com.searchchallenge.domain.usecase

import com.searchchallenge.Resources
import com.searchchallenge.domain.repository.ISearchProductRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class SearchProductUseCaseTest {

    private val repository: ISearchProductRepository = mockk()
    private val useCase = SearchProductUseCase(repository)

    @Test
    fun `given SearchProductUseCase when SearchProductRepository is invoked then returns success`() =
        runTest {
            //given
            coEvery { repository.searchProducts(Resources.Query) } returns Resources.productDomainListParameterProvider

            //when
            val productList = useCase.invoke(Resources.Query)

            //then
            assert(productList.isNotEmpty())
        }

    @Test
    fun `search product returns error`() = runTest {
        // TO..DO
    }

}