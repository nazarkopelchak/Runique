package com.nazarkopelchak.run.presentation.di

import com.nazarkopelchak.run.domain.RunningTracker
import com.nazarkopelchak.run.presentation.active_run.ActiveRunViewModel
import com.nazarkopelchak.run.presentation.run_overview.RunOverviewViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val runPresentationModule = module {
    singleOf(::RunningTracker)

    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}