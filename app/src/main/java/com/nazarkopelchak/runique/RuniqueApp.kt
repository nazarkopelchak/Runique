package com.nazarkopelchak.runique

import android.app.Application
import com.nazarkopelchak.auth.data.di.authDataModule
import com.nazarkopelchak.auth.presentation.di.authViewModelModule
import com.nazarkopelchak.core.data.di.coreDataModule
import com.nazarkopelchak.run.presentation.run_overview.di.runViewModelModule
import com.nazarkopelchak.runique.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule,
                runViewModelModule
            )
        }
    }
}