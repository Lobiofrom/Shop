package com.example.feature_catalogue.domain.models

import com.example.network.dto.InfoDto

data class Info(
    val title: String,
    val value: String
)
fun InfoDto.toInfo() = Info(
    title = title,
    value = value
)