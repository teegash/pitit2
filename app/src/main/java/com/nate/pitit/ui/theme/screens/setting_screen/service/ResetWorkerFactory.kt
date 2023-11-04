package com.nate.pitit.ui.theme.screens.setting_screen.service

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.nate.pitit.models.usecase.write_datastore.EditExpLimitUseCase

import javax.inject.Inject

class ResetWorkerFactory @Inject constructor(private val editExpenseLimitUseCase: EditExpLimitUseCase) :
    WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return LimitResetWorker(appContext, workerParameters, editExpenseLimitUseCase)
    }
}