package com.example.database.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemFromDb(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "oldPrice")
    val oldPrice: String,
    @ColumnInfo(name = "newPrice")
    val newPrice: String,
    @ColumnInfo(name = "discount")
    val discount: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "subtitle")
    val subtitle: String,
    @ColumnInfo(name = "rating")
    val rating: String,
    @ColumnInfo(name = "feedBackCount")
    val feedBackCount: String,
)
