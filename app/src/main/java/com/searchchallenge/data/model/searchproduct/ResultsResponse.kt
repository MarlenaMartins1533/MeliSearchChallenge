package com.searchchallenge.data.model.searchproduct

import com.google.gson.annotations.SerializedName

data class ResultsResponse(
    @SerializedName("id")
    val productId: String,
    @SerializedName("date_created")
    val dateCreated: String,
    @SerializedName("catalog_product_id")
    val catalogProductId: String,
    @SerializedName("pdp_types")
    val pdpTypes: List<String>? = null,
    @SerializedName("status")
    val status: String,
    @SerializedName("domain_id")
    val domainId: String,
    @SerializedName("settings")
    val settings: Settings,
    @SerializedName("name")
    val productName: String,
    @SerializedName("main_features")
    val mainFeatures: List<String>? = null,
    @SerializedName("attributes")
    val attributes: List<UsedAttributesResponse>,
    @SerializedName("pictures")
    val pictures: List<PictureResponse>,
    @SerializedName("parent_id")
    val parentId: String?,
    @SerializedName("children_ids")
    val childrenIds: List<String>? = null,
    @SerializedName("quality_type")
    val qualityType: String,
    @SerializedName("priority")
    val priority: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("site_id")
    val siteId: String,
    @SerializedName("variations")
    val variations: List<String>? = null,
    @SerializedName("keywords")
    val keywords: String,
    @SerializedName("description")
    val description: String,
)

data class Settings(
    @SerializedName("listing_strategy")
    val listingStrategy: String,
    @SerializedName("exclusive")
    val exclusive: Boolean
)
