package com.searchchallenge.data.remote.mapper

import com.searchchallenge.data.model.searchproduct.PictureResponse
import com.searchchallenge.data.model.searchproduct.ResultsResponse
import com.searchchallenge.domain.model.PictureDomain
import com.searchchallenge.domain.model.ProductDomain
import com.searchchallenge.util.Mapper

class ResponseToDomainMapper : Mapper<ResultsResponse, ProductDomain> {
    override fun invoke(input: ResultsResponse): ProductDomain = ProductDomain(
        productId = input.productId,
        productName = input.productName,
        pictures = input.pictures.map { PictureResponseToDomainMapper().invoke(it) },
        description = input.description
    )
}

class PictureResponseToDomainMapper : Mapper<PictureResponse, PictureDomain> {
    override fun invoke(input: PictureResponse): PictureDomain = PictureDomain(
        pictureId = input.pictureId,
        url = input.url
    )
}
