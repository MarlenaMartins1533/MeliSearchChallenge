package com.searchchallenge.data.model.searchproduct

import com.google.gson.annotations.SerializedName

data class PaginationResponse(
    @SerializedName("total")
    val total: Int,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("offset")
    val offset: Int
)