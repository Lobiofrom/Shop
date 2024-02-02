package com.example.feature_catalogue.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.database.domain.models.ItemFromDb
import com.example.database.domain.usecase.DbUseCase
import com.example.feature_catalogue.data.States
import com.example.feature_catalogue.domain.usecase.GetItemsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CatalogueViewModel(
    private val getItemsUseCase: GetItemsUseCase,
    private val dbUseCase: DbUseCase
) : ViewModel() {
    private var _state = MutableStateFlow<States>(States.Loading)
    val state = _state.asStateFlow()

    val itemList = this.dbUseCase.executeList()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    fun upsertItemToDb(
        id: String,
        oldPrice: String,
        newPrice: String,
        discount: String,
        title: String,
        subtitle: String,
        rating: String,
        feedBackCount: String
    ) {
        viewModelScope.launch {
            val item = ItemFromDb(
                id = id,
                oldPrice = oldPrice,
                newPrice = newPrice,
                discount = discount,
                title = title,
                subtitle = subtitle,
                rating = rating,
                feedBackCount = feedBackCount
            )
            dbUseCase.upsert(item)
        }
    }

    fun deleteItem(itemFromDb: ItemFromDb) {
        viewModelScope.launch {
            dbUseCase.executeDelete(itemFromDb)
        }
    }

    fun getFullList() {
        _state.value = States.Loading
        viewModelScope.launch {
            try {
                val sorted = getItemsUseCase.execute().sortedByDescending {
                    it.feedback.rating
                }
                _state.value = States.Success(sorted)
            } catch (e: Exception) {
                _state.value = States.Error(e.message)
            }
        }
    }

    fun getFaceFilter() {
        _state.value = States.Loading
        viewModelScope.launch {
            try {
                val filtered = getItemsUseCase.execute().filter { item ->
                    item.tags.contains("face")
                }
                _state.value = States.Success(filtered)

            } catch (e: Exception) {
                _state.value = States.Error(e.message)
            }
        }
    }

    fun getBodyFilter() {
        _state.value = States.Loading
        viewModelScope.launch {
            try {
                val filtered = getItemsUseCase.execute().filter { item ->
                    item.tags.contains("body")
                }
                _state.value = States.Success(filtered)
            } catch (e: Exception) {
                _state.value = States.Error(e.message)
            }
        }
    }

    fun getSunFilter() {
        _state.value = States.Loading
        viewModelScope.launch {
            try {
                val filtered = getItemsUseCase.execute().filter { item ->
                    item.tags.contains("suntan")
                }
                _state.value = States.Success(filtered)
            } catch (e: Exception) {
                _state.value = States.Error(e.message)
            }
        }
    }

    fun getMaskFilter() {
        _state.value = States.Loading
        viewModelScope.launch {
            try {
                val filtered = getItemsUseCase.execute().filter { item ->
                    item.tags.contains("mask")
                }
                _state.value = States.Success(filtered)
            } catch (e: Exception) {
                _state.value = States.Error(e.message)
            }
        }
    }
}