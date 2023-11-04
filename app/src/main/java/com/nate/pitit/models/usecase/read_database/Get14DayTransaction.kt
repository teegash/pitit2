package com.nate.pitit.models.usecase.read_database

import com.nate.pitit.data.local.entity.TransactionDataTransferObject
import com.nate.pitit.models.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Get14DayTransaction @Inject constructor(

    private val transactionRepository: TransactionRepository
) {

    operator fun invoke(transactionType: String): Flow<List<TransactionDataTransferObject>> {
        return transactionRepository.get3DayTransaction(transactionType)
    }
}

// Get 14 days transaction of income.