package com.nazarkopelchak.core.domain.run

import com.nazarkopelchak.core.domain.util.DataError
import kotlinx.coroutines.flow.Flow
import com.nazarkopelchak.core.domain.util.Result

typealias RunId = String

interface LocalRunDataSource {
    fun getRuns(): Flow<List<Run>>
    suspend fun upsertRun(run: Run): Result<RunId, DataError.Local>
    suspend fun upsertRuns(runs: List<Run>): Result<List<RunId>, DataError.Local>
    suspend fun deleteRun(id: String)
    suspend fun deleteAllRuns()
}