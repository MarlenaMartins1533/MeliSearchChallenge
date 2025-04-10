package com.searchchallenge.data.model.searchproduct

import com.google.gson.annotations.SerializedName

data class PictureResponse(
    @SerializedName("id")
    val pictureId: String,
    @SerializedName("url")
    val url: String,
)
