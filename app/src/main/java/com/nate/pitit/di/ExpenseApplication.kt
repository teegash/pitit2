package com.nate.pitit.di

import android.app.Application
import androidx.work.Configuration
import com.nate.pitit.ui.theme.screens.setting_screen.service.ResetWorkerFactory
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class ExpenseApplication : Application(), Configuration.Provider {

    @Inject
    lateinit var factory: ResetWorkerFactory

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setMinimumLoggingLevel(android.util.Log.DEBUG)
            .setWorkerFactory(factory)
            .build()
    }
}