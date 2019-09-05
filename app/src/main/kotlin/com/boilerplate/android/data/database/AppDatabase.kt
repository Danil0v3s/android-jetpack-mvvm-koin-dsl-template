package com.boilerplate.android.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.boilerplate.android.business.model.DummyEntity
import com.boilerplate.android.data.database.converter.ListStringTypeConverter
import com.boilerplate.android.data.database.dao.DummyDao

@Database(
    entities = [DummyEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ListStringTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dummyDao(): DummyDao
}