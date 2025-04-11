package com.searchchallenge.data.remote.datasource.parameterprovider

import com.searchchallenge.domain.model.PictureDomain
import com.searchchallenge.domain.model.ProductDomain

// Mock data
var productResponseListParameterProvider = listOf(
    ProductDomain(
        productId = "Sample Id",
        productName = "Sample Name",
        pictures = listOf(PictureDomain(" ", "R.drawable.baseline_add_shopping_cart_24")),
        description = "Sample description! " +
                "Produto mirabilis ad [activitatem] cum [pluma desiderata] et [beneficium clavem].",
    ),
    ProductDomain(
        productId = "Sample Id",
        productName = "Sample Second Name",
        pictures = listOf(PictureDomain(" ", "R.drawable.baseline_add_shopping_cart_24")),
        description = "Sample second description! " +
                "Produto Second mirabilis ad [activitatem] cum [pluma desiderata] et [beneficium clavem].",
    )
)

var productListNamesParameterProvider = listOf("Sample Name", "Other Sample Name")