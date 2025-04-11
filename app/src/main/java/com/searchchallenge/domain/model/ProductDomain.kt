package com.searchchallenge.domain.model

data class ProductDomain(
    val productId: String,
    val productName: String,
    val pictures: List<PictureDomain>,
    val description: String,
)
