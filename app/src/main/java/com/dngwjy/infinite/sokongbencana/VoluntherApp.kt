package com.dngwjy.infinite.sokongbencana

import android.app.Application
import com.dngwjy.infinite.sokongbencana.di.netModule
import com.dngwjy.infinite.sokongbencana.di.preferencesModule
import com.dngwjy.infinite.sokongbencana.di.repoModule
import com.dngwjy.infinite.sokongbencana.di.viewModelModule
import org.koin.android.ext.android.startKoin

class VoluntherApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, arrayListOf(netModule, repoModule, viewModelModule))
    }
}