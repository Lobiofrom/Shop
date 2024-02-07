package com.example.feature_catalogue.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.feature_catalogue.domain.models.Item
import com.example.feature_catalogue.viewmodel.CatalogueViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun CatalogueScreen(
    catalogueViewModel: CatalogueViewModel = koinViewModel()
) {

    val state = catalogueViewModel.state.collectAsState()

    var item by remember {
        mutableStateOf<Item?>(null)
    }

    var showCatalogueScreen by remember {
        mutableStateOf(true)
    }

    if (showCatalogueScreen) {
        FullListScreen(state = state, catalogueViewModel = catalogueViewModel) {
            item = it
            showCatalogueScreen = false
        }
    } else {
        item?.let {
            DetailScreen(
                item = it,
                catalogueViewModel = catalogueViewModel,
                onBackClick = {
                    showCatalogueScreen = true
                }
            )
        }
    }
}