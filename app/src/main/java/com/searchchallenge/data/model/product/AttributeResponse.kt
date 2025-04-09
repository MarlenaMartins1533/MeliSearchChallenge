package com.searchchallenge.data.model.product

import com.google.gson.annotations.SerializedName

data class AttributeResponse(
    @SerializedName("id")
    val attributeId: String,
    @SerializedName("name")
    val attributeName: String,
    @SerializedName("value_name")
    val valueName: String?
)
