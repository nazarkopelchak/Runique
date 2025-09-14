package com.nazarkopelchak.run.presentation.run_overview.di

import com.nazarkopelchak.run.presentation.active_run.ActiveRunViewModel
import com.nazarkopelchak.run.presentation.run_overview.RunOverviewViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val runViewModelModule = module {
    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}