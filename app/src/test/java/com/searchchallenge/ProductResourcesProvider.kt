package com.searchchallenge

import com.searchchallenge.domain.model.PictureDomain
import com.searchchallenge.domain.model.ProductDomain
import com.searchchallenge.ui.composable.model.Product

// Mock data

object Resources {
    const val Query = "s20"
    var productListNamesParameterProvider = mutableListOf("Sample Name", "Other Sample Name")

    var productDomainListParameterProvider = mutableListOf(
        ProductDomain(
            productId = "Sample Id",
            productName = "Sample Name",
            pictures = mutableListOf(
                PictureDomain(
                    " ",
                    "R.drawable.baseline_add_shopping_cart_24"
                )
            ),
            description = "Sample description! " +
                    "Produto mirabilis ad [activitatem] cum [pluma desiderata] et [beneficium clavem].",
        ),
        ProductDomain(
            productId = "Sample Id",
            productName = "Sample Second Name",
            pictures = mutableListOf(
                PictureDomain(
                    " ",
                    "R.drawable.baseline_add_shopping_cart_24"
                )
            ),
            description = "Sample second description! " +
                    "Produto Second mirabilis ad [activitatem] cum [pluma desiderata] et [beneficium clavem].",
        )
    )

    var productListParameterProvider = listOf(
        Product(
            id = "Sample Id",
            name = "Sample Name",
            images = listOf("R.drawable.baseline_add_shopping_cart_24"),
            description = "Sample description! " +
                    "Produto mirabilis ad [activitatem] cum [pluma desiderata] et [beneficium clavem].",
        ),
        Product(
            id = "Sample Id",
            name = "Sample Second Name",
            images = listOf("R.drawable.baseline_add_shopping_cart_24"),
            description = "Sample second description! " +
                    "Produto Second mirabilis ad [activitatem] cum [pluma desiderata] et [beneficium clavem].",
        )
    )
}