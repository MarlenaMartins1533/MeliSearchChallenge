package com.searchchallenge.data.model.product

import com.google.gson.annotations.SerializedName

data class PictureResponse(
    @SerializedName("id")
    val pictureId: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("size")
    val size: String,
    @SerializedName("max_size")
    val maxSize: String
)
