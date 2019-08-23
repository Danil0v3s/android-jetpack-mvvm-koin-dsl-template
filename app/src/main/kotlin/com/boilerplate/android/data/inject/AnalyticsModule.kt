package com.boilerplate.android.data.inject

import com.boilerplate.android.business.analytics.AnalyticsService
import com.boilerplate.android.business.analytics.FirebaseAnalyticsService
import com.google.firebase.analytics.FirebaseAnalytics
import org.koin.dsl.module.module

val analyticsModule = module {
    single { FirebaseAnalytics.getInstance(get()) }
    single<AnalyticsService>(name = "FirebaseAnalyticsService") {
        FirebaseAnalyticsService(get())
    }
}