package com.nazarkopelchak.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nazarkopelchak.core.database.dao.RunDao
import com.nazarkopelchak.core.database.dao.RunPendingSyncDao
import com.nazarkopelchak.core.database.entity.DeletedRunSyncEntity
import com.nazarkopelchak.core.database.entity.RunEntity
import com.nazarkopelchak.core.database.entity.RunPendingSyncEntity

@Database(
    entities = [
        RunEntity::class,
        RunPendingSyncEntity::class,
        DeletedRunSyncEntity::class
    ],
    version = 1
)
abstract class RunDatabase: RoomDatabase() {

    abstract val runDao: RunDao
    abstract val runPendingSyncDao: RunPendingSyncDao
}