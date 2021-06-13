package com.byjusassignement

import android.app.Application
import androidx.multidex.MultiDex
import com.byjusassignement.di.networkModule
import com.byjusassignement.di.persistenceModule
import com.byjusassignement.di.repositoryModule
import com.byjusassignement.di.viewModelModule
import com.byjusassignement.operator.GlobalResponseOperator
import com.facebook.stetho.Stetho
import com.skydoves.sandwich.SandwichInitializer
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@Suppress("unused")
class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)

        startKoin {
            androidContext(this@AppApplication)
            modules(networkModule)
            modules(persistenceModule)
            modules(repositoryModule)
            modules(viewModelModule)
        }

        SandwichInitializer.sandwichOperator = GlobalResponseOperator<Any>(this)

        Stetho.initializeWithDefaults(this)
    }
}