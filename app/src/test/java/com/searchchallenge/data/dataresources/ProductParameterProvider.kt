package com.searchchallenge.data.dataresources

import com.searchchallenge.domain.model.PictureDomain
import com.searchchallenge.domain.model.ProductDomain
// Mock data

object Resources {
    const val Query = "s20"
    var productResponseListParameterProvider = mutableListOf(
        ProductDomain(
            productId = "Sample Id",
            productName = "Sample Name",
            pictures = mutableListOf(PictureDomain(" ", "R.drawable.baseline_add_shopping_cart_24")),
            description = "Sample description! " +
                    "Produto mirabilis ad [activitatem] cum [pluma desiderata] et [beneficium clavem].",
        ),
        ProductDomain(
            productId = "Sample Id",
            productName = "Sample Second Name",
            pictures = mutableListOf(PictureDomain(" ", "R.drawable.baseline_add_shopping_cart_24")),
            description = "Sample second description! " +
                    "Produto Second mirabilis ad [activitatem] cum [pluma desiderata] et [beneficium clavem].",
        )
    )

    var productListNamesParameterProvider = mutableListOf("Sample Name", "Other Sample Name")
}