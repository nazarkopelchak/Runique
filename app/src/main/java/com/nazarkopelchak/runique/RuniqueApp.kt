package com.nazarkopelchak.runique

import android.app.Application
import android.content.Context
import com.google.android.play.core.splitcompat.SplitCompat
import com.nazarkopelchak.auth.data.di.authDataModule
import com.nazarkopelchak.auth.presentation.di.authViewModelModule
import com.nazarkopelchak.core.data.di.coreDataModule
import com.nazarkopelchak.core.database.di.databaseModule
import com.nazarkopelchak.run.data.di.runDataModule
import com.nazarkopelchak.run.location.di.locationModule
import com.nazarkopelchak.run.network.di.networkModule
import com.nazarkopelchak.run.presentation.di.runPresentationModule
import com.nazarkopelchak.runique.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp: Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            workManagerFactory()
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule,
                runPresentationModule,
                locationModule,
                databaseModule,
                networkModule,
                runDataModule
            )
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        SplitCompat.install(this)
    }
}