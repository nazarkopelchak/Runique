package com.nazarkopelchak.run.data.di

import com.nazarkopelchak.core.domain.run.SyncRunScheduler
import com.nazarkopelchak.run.data.CreateRunWorker
import com.nazarkopelchak.run.data.DeleteRunWorker
import com.nazarkopelchak.run.data.FetchRunsWorker
import com.nazarkopelchak.run.data.SyncRunWorkerScheduler
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)
    workerOf(::CreateRunWorker)

    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()
}