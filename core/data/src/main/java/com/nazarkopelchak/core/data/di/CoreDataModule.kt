package com.nazarkopelchak.core.data.di

import com.nazarkopelchak.core.data.auth.EncryptedSessionStorage
import com.nazarkopelchak.core.data.networking.HttpClientFactory
import com.nazarkopelchak.core.data.run.OfflineFirstRunRepository
import com.nazarkopelchak.core.domain.SessionStorage
import com.nazarkopelchak.core.domain.run.RunRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
    singleOf(::OfflineFirstRunRepository).bind<RunRepository>()
}