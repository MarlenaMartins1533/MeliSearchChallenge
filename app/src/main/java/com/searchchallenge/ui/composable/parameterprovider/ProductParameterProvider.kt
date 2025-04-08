package com.searchchallenge.ui.composable.parameterprovider

import com.searchchallenge.R
import com.searchchallenge.ui.composable.model.Product

// Mock data
var productListParameterProvider = listOf(
    Product(
        R.drawable.baseline_add_shopping_cart_24,
        name = "Sample Name",
        description = "Sample description! " +
                "Produto mirabilis ad [activitatem] cum [pluma desiderata] et [beneficium clavem].",
        rating = 5.0
    ),
    Product(
        R.drawable.baseline_add_shopping_cart_24,
        name = "Sample Second Name",
        description = "Sample second description! " +
                "Produto Second mirabilis ad [activitatem] cum [pluma desiderata] et [beneficium clavem].",
        rating = 3.0
    )
)

var productListNamesParameterProvider = listOf("Sample Name", "Other Sample Name")