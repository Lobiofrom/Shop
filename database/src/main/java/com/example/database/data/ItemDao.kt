package com.example.database.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.database.domain.models.ItemFromDb
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Upsert
    suspend fun upsertItem(itemFromDb: ItemFromDb)

    @Query("select * from ItemFromDb")
    fun getList(): Flow<List<ItemFromDb>>

    @Query("select * from ItemFromDb where id = :id")
    suspend fun getItemById(id: String): ItemFromDb?

    @Delete
    suspend fun deleteItem(item: ItemFromDb)

}