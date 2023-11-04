package com.nate.pitit.models.repository

import com.nate.pitit.data.local.entity.AccountDataTransferObject
import com.nate.pitit.data.local.entity.TransactionDataTransferObject
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {

    suspend fun insertTransaction(dailyExpense: TransactionDataTransferObject)

    suspend fun insertAccount(accounts: List<AccountDataTransferObject>)

    fun getDailyTransaction(entryDate: String): Flow<List<TransactionDataTransferObject>>

    fun getTransactionByAccountType(accountType: String): Flow<List<TransactionDataTransferObject>>

    fun getAccount(account: String): Flow<AccountDataTransferObject>

    fun getAccounts(): Flow<List<AccountDataTransferObject>>

    fun getAllTransactions(): Flow<List<TransactionDataTransferObject>>

    fun eraseTransaction()

    fun getCurrentDayExpTransaction(): Flow<List<TransactionDataTransferObject>>

    fun getWeeklyExpTransaction(): Flow<List<TransactionDataTransferObject>>

    fun getMonthlyExpTransaction(): Flow<List<TransactionDataTransferObject>>

    fun get3DayTransaction(transactionType: String): Flow<List<TransactionDataTransferObject>>

    fun get7DayTransaction(transactionType: String): Flow<List<TransactionDataTransferObject>>

    fun get14DayTransaction(transactionType: String): Flow<List<TransactionDataTransferObject>>

    fun startOfTheMonthTransaction(transactionType: String): Flow<List<TransactionDataTransferObject>>

    fun getLastMonthTransaction(transactionType: String): Flow<List<TransactionDataTransferObject>>

    fun getTransactionByType(transactionType: String): Flow<List<TransactionDataTransferObject>>

}