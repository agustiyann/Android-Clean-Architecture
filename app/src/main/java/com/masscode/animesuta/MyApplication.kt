package com.masscode.animesuta

import android.app.Application
import com.masscode.animesuta.core.di.databaseModule
import com.masscode.animesuta.core.di.networkModule
import com.masscode.animesuta.core.di.repositoryModule
import com.masscode.animesuta.di.useCaseModule
import com.masscode.animesuta.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}