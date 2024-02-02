package com.example.database.data

import com.example.database.domain.dbrepo.DbRepo
import com.example.database.domain.models.ItemFromDb
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class DbRepoImpl(
    private val itemDataBase: ItemDataBase
) : DbRepo {
    override suspend fun upsertItem(itemFromDb: ItemFromDb) {
        withContext(Dispatchers.IO) {
            itemDataBase.itemDao().upsertItem(itemFromDb)
        }
    }

    override fun getItemList(): Flow<List<ItemFromDb>> {
        return itemDataBase.itemDao().getList()
    }

    override suspend fun searchItemInDb(id: String): ItemFromDb? {
        return withContext(Dispatchers.IO) {
            itemDataBase.itemDao().getItemById(id)
        }
    }

    override suspend fun deleteItem(item: ItemFromDb) {
        withContext(Dispatchers.IO) {
            itemDataBase.itemDao().deleteItem(item)
        }
    }

    override suspend fun clearDb() {
        withContext(Dispatchers.IO) {
            itemDataBase.clearAllTables()
        }
    }
}