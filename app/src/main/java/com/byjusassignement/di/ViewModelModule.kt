package com.byjusassignement.di

import com.byjusassignement.view.ui.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
  viewModel { MainActivityViewModel(get()) }
}
