package com.example.feature_catalogue.domain.usecase

import com.example.feature_catalogue.domain.models.Item
import com.example.feature_catalogue.domain.repository.Repository

class GetItemsUseCase(
    private val repository: Repository
) {
    suspend fun execute(): List<Item> {
        return repository.getData().items
    }
}