package com.nate.pitit.models.usecase.read_database

import com.nate.pitit.data.local.entity.AccountDataTransferObject
import com.nate.pitit.models.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAccountsUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
) {

    operator fun invoke(): Flow<List<AccountDataTransferObject>> {
        return transactionRepository.getAccounts()
    }
}