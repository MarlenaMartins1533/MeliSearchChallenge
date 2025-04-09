package com.searchchallenge.data.model.searchproduct

import com.google.gson.annotations.SerializedName

data class ShippingResponse(
    @SerializedName("free_shipping")
    val freeShipping: Boolean
)
