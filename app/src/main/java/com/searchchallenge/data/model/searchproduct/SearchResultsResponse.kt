package com.searchchallenge.data.model.searchproduct

import com.google.gson.annotations.SerializedName

data class SearchResultsResponse(
    @SerializedName("id")
    val productId: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("price")
    val price: Float,
    @SerializedName("currency_id")
    val currencyId: String,
    @SerializedName("condition")
    val condition: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("shipping")
    val shipping: ShippingResponse
)
