package com.nazarkopelchak.run.location.di

import com.nazarkopelchak.run.domain.LocationObserver
import com.nazarkopelchak.run.location.AndroidLocationObserver
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val locationModule = module {
    singleOf(::AndroidLocationObserver).bind<LocationObserver>()
}