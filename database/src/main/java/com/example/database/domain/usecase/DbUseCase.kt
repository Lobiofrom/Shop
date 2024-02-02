package com.example.database.domain.usecase

import com.example.database.domain.dbrepo.DbRepo
import com.example.database.domain.models.ItemFromDb
import kotlinx.coroutines.flow.Flow

class DbUseCase(
    private val dbRepo: DbRepo
) {
    suspend fun upsert(itemFromDb: ItemFromDb) {
        dbRepo.upsertItem(itemFromDb)
    }

    fun executeList(): Flow<List<ItemFromDb>> {
        return dbRepo.getItemList()
    }

    suspend fun executeSearch(id: String): ItemFromDb? {
        return dbRepo.searchItemInDb(id)
    }

    suspend fun executeDelete(item: ItemFromDb) {
        dbRepo.deleteItem(item)
    }

    suspend fun executeClearDb() {
        dbRepo.clearDb()
    }
}