package com.example.feature_catalogue.domain.models

import com.example.network.dto.FeedbackDto

data class Feedback(
    val count: Int,
    val rating: Double
)
fun FeedbackDto.toFeedback() = Feedback(
    count = count,
    rating = rating
)