package com.nate.pitit.ui.theme.screens.setting_screen.service

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.nate.pitit.models.usecase.write_datastore.EditExpLimitUseCase

class LimitResetWorker(context: Context, workParams: WorkerParameters, val editExpenseLimitUseCase: EditExpLimitUseCase) :
    CoroutineWorker(context, workParams) {
    override suspend fun doWork(): Result {
        editExpenseLimitUseCase(0.0)
        return Result.success()
    }
}