package com.nazarkopelchak.run.network.di

import com.nazarkopelchak.core.domain.run.RemoteRunDataSource
import com.nazarkopelchak.run.network.KtorRemoteRunDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    singleOf(::KtorRemoteRunDataSource).bind<RemoteRunDataSource>()
}