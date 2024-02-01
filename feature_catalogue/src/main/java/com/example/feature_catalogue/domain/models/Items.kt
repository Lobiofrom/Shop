package com.example.feature_catalogue.domain.models

import com.example.network.dto.ItemsDto

data class Items(
    val items: List<Item>
)

fun ItemsDto.toItems() = Items(
    items = items.map {
        it.toItem()
    }
)