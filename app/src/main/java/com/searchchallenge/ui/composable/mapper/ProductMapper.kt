package com.searchchallenge.ui.composable.mapper

import com.searchchallenge.domain.model.ProductDomain
import com.searchchallenge.ui.composable.model.Product
import com.searchchallenge.util.Mapper

class DomainToProductMapper : Mapper<List<ProductDomain>, List<Product>> {
    override fun invoke(input: List<ProductDomain>): List<Product> =
        input.map {
            Product(
                id = it.productId,
                name = it.productName,
                images = it.pictures.map { picture -> picture.url },
                description = it.description
            )
        }
}
