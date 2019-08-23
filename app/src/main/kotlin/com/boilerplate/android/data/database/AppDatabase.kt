package com.boilerplate.android.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.boilerplate.android.business.model.Category
import com.boilerplate.android.data.database.converter.ListCategoryTypeConverter

@Database(
    entities = [Category::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ListCategoryTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

}