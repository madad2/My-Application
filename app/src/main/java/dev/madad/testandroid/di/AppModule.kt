package dev.madad.testandroid.di

import dev.madad.testandroid.MainViewModel
import dev.madad.testandroid.model.repositories.MainRepository
import dev.madad.testandroid.model.repositories.Repository
import dev.madad.testandroid.model.retrofit.RetrofitClient
import dev.madad.testandroid.view.UserInfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { RetrofitClient.create() }
    single<Repository> { MainRepository(api = get()) }
    viewModel { MainViewModel(repository = get()) }
    viewModel { UserInfoViewModel(repository = get()) }
}