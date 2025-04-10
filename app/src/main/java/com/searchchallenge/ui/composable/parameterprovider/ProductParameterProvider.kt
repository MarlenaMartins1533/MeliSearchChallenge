package com.searchchallenge.ui.composable.parameterprovider

import com.searchchallenge.ui.composable.model.Product

// Mock data
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

var productListNamesParameterProvider = listOf("Sample Name", "Other Sample Name")