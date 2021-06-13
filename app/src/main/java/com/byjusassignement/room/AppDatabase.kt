package com.byjusassignement.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.byjusassignement.model.News
import com.byjusassignement.room.converter.SourceConverter


@Database(
    entities = [(News::class)],
    version = 1, exportSchema = false
)
@TypeConverters(
    value = [
        (SourceConverter::class)
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}
