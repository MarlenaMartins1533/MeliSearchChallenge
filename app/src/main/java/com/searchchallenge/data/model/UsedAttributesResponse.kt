package com.searchchallenge.data.model.searchproduct

import com.google.gson.annotations.SerializedName

class UsedAttributesResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("value_id")
    val valueId: String,
    @SerializedName("value_name")
    val valueName: String,
)
