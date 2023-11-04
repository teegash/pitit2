package com.nate.pitit.models.usecase.read_database

import com.nate.pitit.data.local.entity.TransactionDataTransferObject
import com.nate.pitit.models.repository.TransactionRepository
import com.nate.pitit.models.usecase.GetDateUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDailyTransactionUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
) {

    operator fun invoke(entryDate: GetDateUseCase): Flow<List<TransactionDataTransferObject>> {
        return transactionRepository.getDailyTransaction(entryDate)
    }
}