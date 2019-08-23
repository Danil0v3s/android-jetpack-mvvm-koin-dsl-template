package com.boilerplate.android

import androidx.multidex.MultiDexApplication
import com.boilerplate.android.data.inject.*
import org.koin.android.ext.android.startKoin

class MainApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        startKoin(
            this,
            listOf(
                appModule,
                networkModule,
                repositoryModule,
                viewModelModule,
                databaseModule,
                sharedPreferencesModule,
                analyticsModule
            )
        )
    }
}