package com.dngwjy.infinite.sokongbencana.di

import com.dngwjy.infinite.sokongbencana.data.repository.LogisticRepository
import com.dngwjy.infinite.sokongbencana.data.repository.PoskoRepository
import org.koin.dsl.module.module

val repoModule=module{
    single {
        PoskoRepository(get())

    }
    single {
        LogisticRepository(get())
    }
}