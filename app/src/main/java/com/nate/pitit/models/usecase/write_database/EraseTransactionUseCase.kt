package com.nate.pitit.models.usecase.write_database

import com.nate.pitit.models.repository.TransactionRepository
import javax.inject.Inject

class EraseTransactionUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
) {

    operator fun invoke(){
        transactionRepository.eraseTransaction()
    }
}