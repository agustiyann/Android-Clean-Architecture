package com.masscode.animesuta.di

import com.masscode.animesuta.core.domain.usecase.AnimeInteractor
import com.masscode.animesuta.core.domain.usecase.AnimeUseCase
import com.masscode.animesuta.detail.DetailAnimeViewModel
import com.masscode.animesuta.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<AnimeUseCase> { AnimeInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailAnimeViewModel(get()) }
}