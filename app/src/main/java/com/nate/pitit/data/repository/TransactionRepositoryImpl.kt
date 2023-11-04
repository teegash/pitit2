package com.nate.pitit.data.repository

import com.nate.pitit.data.local.TransactionDataAccessObject
import com.nate.pitit.data.local.entity.AccountDataTransferObject
import com.nate.pitit.data.local.entity.TransactionDataTransferObject
import com.nate.pitit.models.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TransactionRepositoryImpl @Inject constructor(
    private val transactionDao: TransactionDataAccessObject
) : TransactionRepository {
    override suspend fun insertTransaction(dailyExpense: TransactionDataTransferObject) {
        transactionDao.insertTransaction(dailyExpense)
    }

    override suspend fun insertAccount(accounts: List<AccountDataTransferObject>) {
        transactionDao.insertAccounts(accounts)
    }

    override fun getDailyTransaction(entryDate: String): Flow<List<TransactionDataTransferObject>> {
        return transactionDao.getDailyTransaction(entryDate)
    }

    override fun getTransactionByAccountType(accountType: String): Flow<List<TransactionDataTransferObject>> {
        return transactionDao.getTransactionByAccount(accountType)
    }

    override fun getAccount(account: String): Flow<AccountDataTransferObject> {
        return transactionDao.getAccount(account)
    }

    override fun getAccounts(): Flow<List<AccountDataTransferObject>> {
        return transactionDao.getAccounts()
    }

    override fun getAllTransactions(): Flow<List<TransactionDataTransferObject>> {
        return transactionDao.getAllTransactions()
    }

    override fun eraseTransaction() {
        transactionDao.eraseTransaction()
    }

    override fun getCurrentDayExpTransaction(): Flow<List<TransactionDataTransferObject>> {
        return transactionDao.getCurrentDayExpTransaction()
    }

    override fun getWeeklyExpTransaction(): Flow<List<TransactionDataTransferObject>> {
        return transactionDao.getWeeklyExpTransaction()
    }

    override fun getMonthlyExpTransaction(): Flow<List<TransactionDataTransferObject>> {
        return transactionDao.getMonthlyExpTransaction()
    }

    override fun get3DayTransaction(transactionType: String): Flow<List<TransactionDataTransferObject>> {
        return transactionDao.get3DayTransaction(transactionType)
    }

    override fun get7DayTransaction(transactionType: String): Flow<List<TransactionDataTransferObject>> {
        return transactionDao.get7DayTransaction(transactionType)
    }

    override fun get14DayTransaction(transactionType: String): Flow<List<TransactionDataTransferObject>> {
        return transactionDao.get14DayTransaction(transactionType)
    }

    override fun startOfTheMonthTransaction(transactionType: String): Flow<List<TransactionDataTransferObject>> {
        return transactionDao.getStartOfMonthTransaction(transactionType)
    }

    override fun getLastMonthTransaction(transactionType: String): Flow<List<TransactionDataTransferObject>> {
        return transactionDao.getLastMonthTransaction(transactionType)
    }

    override fun getTransactionByType(transactionType: String): Flow<List<TransactionDataTransferObject>> {
        return transactionDao.getTransactionByType(transactionType)
    }
}