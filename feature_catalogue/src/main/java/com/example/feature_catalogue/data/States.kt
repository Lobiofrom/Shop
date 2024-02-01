package com.example.feature_catalogue.data

import com.example.feature_catalogue.domain.models.Item

sealed class States {
    data class Success(val items: List<Item>) : States()
    data class Error(val error: String?) : States()
    data object Loading : States()
}