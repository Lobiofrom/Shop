package com.example.database.domain.dbrepo

import com.example.database.domain.models.ItemFromDb
import kotlinx.coroutines.flow.Flow

interface DbRepo {
    suspend fun upsertItem(itemFromDb: ItemFromDb)
    fun getItemList(): Flow<List<ItemFromDb>>
    suspend fun searchItemInDb(id: String): ItemFromDb?
    suspend fun deleteItem(item: ItemFromDb)

    suspend fun clearDb()
}