package com.example.feature_catalogue.data

import com.example.feature_catalogue.domain.models.Items
import com.example.feature_catalogue.domain.models.toItems
import com.example.feature_catalogue.domain.repository.Repository
import com.example.network.retrofit.RetrofitAndApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepoImpl(
    private val retrofitAndApi: RetrofitAndApi
) : Repository {
    override suspend fun getData(): Items {
        return withContext(Dispatchers.IO) {
            retrofitAndApi.api.getData().toItems()
        }
    }
}