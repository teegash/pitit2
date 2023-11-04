package com.nate.pitit.models.usecase.write_database

import com.nate.pitit.data.local.entity.TransactionDataTransferObject
import com.nate.pitit.models.repository.TransactionRepository
import javax.inject.Inject

class InsertNewTransactionUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
) {

    suspend operator fun invoke(dailyExpense: TransactionDataTransferObject){
        transactionRepository.insertTransaction(dailyExpense)
    }
}