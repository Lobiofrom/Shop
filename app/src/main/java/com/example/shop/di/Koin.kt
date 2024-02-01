package com.example.shop.di

import com.example.feature_catalogue.data.RepoImpl
import com.example.feature_catalogue.domain.repository.Repository
import com.example.feature_catalogue.domain.usecase.GetItemsUseCase
import com.example.feature_catalogue.viewmodel.CatalogueViewModel
import com.example.network.retrofit.RetrofitAndApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val module = module {
    single<RetrofitAndApi> { RetrofitAndApi() }
    single<Repository> { RepoImpl(get()) }
    factory { GetItemsUseCase(get()) }
    viewModel { CatalogueViewModel(get()) }
}