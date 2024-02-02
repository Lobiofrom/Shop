package com.example.feature_profile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.database.domain.models.ItemFromDb
import com.example.database.domain.usecase.DbUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val dbUseCase: DbUseCase
) : ViewModel() {
    val itemList = this.dbUseCase.executeList()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    fun deleteItem(itemFromDb: ItemFromDb) {
        viewModelScope.launch {
            dbUseCase.executeDelete(itemFromDb)
        }
    }

    fun clearDb() {
        viewModelScope.launch {
            dbUseCase.executeClearDb()
        }
    }
}