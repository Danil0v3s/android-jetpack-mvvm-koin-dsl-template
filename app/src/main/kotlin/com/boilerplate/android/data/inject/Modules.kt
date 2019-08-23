package com.boilerplate.android.data.inject

import org.koin.dsl.module.module
import java.util.*

val appModule = module {
    single { provideCalendar() }
}

private fun provideCalendar() = Calendar.getInstance()
