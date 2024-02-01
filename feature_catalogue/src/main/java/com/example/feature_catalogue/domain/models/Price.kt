package com.example.feature_catalogue.domain.models

import com.example.network.dto.PriceDto

data class Price(
    val discount: Int,
    val price: String,
    val priceWithDiscount: String,
    val unit: String
)

fun PriceDto.toPrice() = Price(
    discount = discount,
    price = price,
    priceWithDiscount = priceWithDiscount,
    unit = unit
)