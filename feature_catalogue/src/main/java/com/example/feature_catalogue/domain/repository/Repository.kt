package com.example.feature_catalogue.domain.repository

import com.example.feature_catalogue.domain.models.Items

interface Repository {
    suspend fun getData(): Items
}