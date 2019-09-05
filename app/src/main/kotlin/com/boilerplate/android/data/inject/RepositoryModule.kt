package com.boilerplate.android.data.inject

import com.boilerplate.android.data.repository.DummyRepository
import org.koin.dsl.module.module

val repositoryModule = module {
    single { DummyRepository(dummyDao = get(), dummyService = get()) }
}