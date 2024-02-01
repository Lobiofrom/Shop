package com.example.feature_catalogue.domain.models

import com.example.network.dto.ItemDto

data class Item(
    val available: Int,
    val description: String,
    val feedback: Feedback,
    val id: String,
    val info: List<Info>,
    val ingredients: String,
    val price: Price,
    val subtitle: String,
    val tags: List<String>,
    val title: String
)

fun ItemDto.toItem() = Item(
    available = available,
    description = description,
    feedback = feedback.toFeedback(),
    id = id,
    info = info.map {
        it.toInfo()
    },
    ingredients = ingredients,
    price = price.toPrice(),
    subtitle = subtitle,
    tags = tags,
    title = title
)