package com.searchchallenge.data.model.product

import com.google.gson.annotations.SerializedName

data class SellerAddressResponse(
    @SerializedName("city")
    val city: AddressProperty,
    @SerializedName("state")
    val state: AddressProperty
)

data class AddressProperty(
    @SerializedName("name")
    val name: String
)
