package com.byjusassignement.di

import com.byjusassignement.repository.NewRepository
import org.koin.dsl.module

val repositoryModule = module {
  single { NewRepository(get(), get()) }
}
