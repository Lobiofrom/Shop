package com.example.shop.di

import com.example.database.data.DbRepoImpl
import com.example.database.data.ItemDataBase
import com.example.database.domain.dbrepo.DbRepo
import com.example.database.domain.usecase.DbUseCase
import com.example.feature_catalogue.data.RepoImpl
import com.example.feature_catalogue.domain.repository.Repository
import com.example.feature_catalogue.domain.usecase.GetItemsUseCase
import com.example.feature_catalogue.viewmodel.CatalogueViewModel
import com.example.feature_profile.viewmodel.ProfileViewModel
import com.example.network.retrofit.RetrofitAndApi
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val module = module {
    single {
        ItemDataBase.getDatabase(androidContext())
    }
    single<RetrofitAndApi> { RetrofitAndApi() }
    single<Repository> { RepoImpl(get()) }
    single<DbRepo> { DbRepoImpl(get()) }
    factory { GetItemsUseCase(get()) }
    factory { DbUseCase(get()) }
    viewModel { CatalogueViewModel(get(), get()) }
    viewModel { ProfileViewModel(get()) }

}