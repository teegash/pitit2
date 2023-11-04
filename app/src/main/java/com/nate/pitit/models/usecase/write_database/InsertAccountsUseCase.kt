package com.nate.pitit.models.usecase.write_database

import com.nate.pitit.data.local.entity.AccountDataTransferObject
import com.nate.pitit.models.repository.TransactionRepository
import javax.inject.Inject

class InsertAccountsUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
) {

    suspend operator fun invoke(accounts: List<AccountDataTransferObject>){
        transactionRepository.insertAccount(accounts)
    }
}
