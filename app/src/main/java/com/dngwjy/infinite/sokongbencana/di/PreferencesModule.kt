package com.dngwjy.infinite.sokongbencana.di

import com.dngwjy.infinite.sokongbencana.data.shared.Preferences
import org.koin.dsl.module.module

val preferencesModule=module{
    Preferences(get())
}