package com.searchchallenge.data.model.searchproduct

import com.google.gson.annotations.SerializedName

data class PaginationResponse(
    @SerializedName("total")
    val total: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("primary_results")
    val primaryResults: Int
)