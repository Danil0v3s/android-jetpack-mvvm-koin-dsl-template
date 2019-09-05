package com.boilerplate.android.data.inject

import android.content.Context
import androidx.room.Room
import com.boilerplate.android.data.database.AppDatabase
import org.koin.dsl.module.module

val databaseModule = module {
    single { provideAppDatabase(get()) }
    single { provideDummyDao(get()) }
}

const val DATABASE_NAME = "app_db"

private fun provideAppDatabase(context: Context): AppDatabase {
    return Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        DATABASE_NAME
    ).build()
}

private fun provideDummyDao(database: AppDatabase) = database.dummyDao()