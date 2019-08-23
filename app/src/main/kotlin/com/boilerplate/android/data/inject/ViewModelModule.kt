package com.boilerplate.android.data.inject

import com.boilerplate.android.base.feature.launchscreen.LaunchScreenViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { LaunchScreenViewModel(get()) }
}