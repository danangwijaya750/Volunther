package com.dngwjy.infinite.sokongbencana.di

import com.dngwjy.infinite.sokongbencana.ui.viewmodels.PoskoViewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    single {
        PoskoViewModel(get())
    }
}