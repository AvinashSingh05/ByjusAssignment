package com.byjusassignement.di

import androidx.room.Room
import com.byjusassignement.room.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val persistenceModule = module {
  single {
    Room
      .databaseBuilder(androidApplication(), AppDatabase::class.java, "byjus.db")
      .allowMainThreadQueries()
      .build()
  }

  single { get<AppDatabase>().newsDao() }
}
