package com.searchchallenge.data.model.searchproduct

import com.google.gson.annotations.SerializedName

data class SearchProductResponse(
    @SerializedName("keywords")
    val keywords: String,
    @SerializedName("paging")
    val paging: PaginationResponse,
    @SerializedName("results")
    val results: ArrayList<ResultsResponse>,
    @SerializedName("used_attributes")
    val usedAttributes: ArrayList<UsedAttributesResponse>,
    @SerializedName("query_type")
    val queryType: String,
)
