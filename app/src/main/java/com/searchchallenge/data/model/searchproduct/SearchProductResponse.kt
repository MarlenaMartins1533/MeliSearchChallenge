package com.searchchallenge.data.model.searchproduct

import com.google.gson.annotations.SerializedName

data class SearchProductResponse(
    @SerializedName("site_id")
    val siteId: String,
    @SerializedName("query")
    val query: String,
    @SerializedName("paging")
    val paging: Pagination,
    @SerializedName("results")
    val results: ArrayList<SearchResultsResponse>
)
