package com.nazarkopelchak.analytics.data.di

import com.nazarkopelchak.analytics.data.RoomAnalyticsRepository
import com.nazarkopelchak.analytics.domain.AnalyticsRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val analyticsModule = module {
    singleOf(::RoomAnalyticsRepository).bind<AnalyticsRepository>()
}