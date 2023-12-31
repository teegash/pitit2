package com.nate.pitit.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nate.pitit.common.TransactionType
import com.nate.pitit.data.local.entity.AccountDataTransferObject
import com.nate.pitit.data.local.entity.TransactionDataTransferObject
import kotlinx.coroutines.flow.Flow


@Dao
interface TransactionDataAccessObject {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transactionDto: TransactionDataTransferObject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAccounts(accounts: List<AccountDataTransferObject>)

    @Query("SELECT * FROM transaction_table WHERE entry_date=:entryDate")
    fun getDailyTransaction(entryDate: String): Flow<List<TransactionDataTransferObject>>

    @Query("SELECT * FROM transaction_table WHERE account=:accountType")
    fun getTransactionByAccount(accountType: String): Flow<List<TransactionDataTransferObject>>

    @Query("SELECT * FROM accounts_table WHERE account=:account")
    fun getAccount(account: String): Flow<AccountDataTransferObject>

    @Query("SELECT * FROM accounts_table")
    fun getAccounts(): Flow<List<AccountDataTransferObject>>

    @Query("SELECT * FROM transaction_table")
    fun getAllTransactions(): Flow<List<TransactionDataTransferObject>>

    @Query("DELETE FROM transaction_table")
    fun eraseTransaction()

    @Query("SELECT * FROM transaction_table WHERE entry_date= date('now','localtime') AND transaction_type=:transactionType")
    fun getCurrentDayExpTransaction(transactionType: String = TransactionType.EXPENSE.title) : Flow<List<TransactionDataTransferObject>>

    @Query("SELECT * FROM transaction_table WHERE entry_date BETWEEN date('now','-1 month') AND date('now','localtime') AND transaction_type = :transactionType")
    fun getMonthlyExpTransaction(transactionType: String = TransactionType.EXPENSE.title): Flow<List<TransactionDataTransferObject>>


    @Query("SELECT * FROM transaction_table WHERE entry_date BETWEEN date('now','-7 day') AND date('now','localtime') AND transaction_type = :transactionType")
    fun getWeeklyExpTransaction(transactionType: String = TransactionType.EXPENSE.title): Flow<List<TransactionDataTransferObject>>


    @Query("SELECT * FROM transaction_table WHERE entry_date >= date('now','-3 day') AND entry_date < date('now','localtime') AND transaction_type = :transactionType")
    fun get3DayTransaction(transactionType: String): Flow<List<TransactionDataTransferObject>>

    @Query("SELECT * FROM transaction_table WHERE entry_date >= date('now','-7 day') AND entry_date < date('now','localtime') AND transaction_type = :transactionType")
    fun get7DayTransaction(transactionType: String): Flow<List<TransactionDataTransferObject>>

    @Query("SELECT * FROM transaction_table WHERE entry_date >= date('now','-14 day') AND entry_date < date('now','localtime') AND transaction_type = :transactionType")
    fun get14DayTransaction(transactionType: String): Flow<List<TransactionDataTransferObject>>

    @Query("SELECT * FROM transaction_table WHERE transaction_type = :transactionType")
    fun getTransactionByType(transactionType: String): Flow<List<TransactionDataTransferObject>>

    @Query("SELECT * FROM transaction_table WHERE entry_date >= date('now','start of month') AND entry_date < date('now','localtime') AND transaction_type = :transactionType")
    fun getStartOfMonthTransaction(transactionType: String): Flow<List<TransactionDataTransferObject>>

    @Query("SELECT * FROM transaction_table WHERE entry_date >= date('now','-1 month') AND entry_date < date('now','localtime') AND transaction_type = :transactionType")
    fun getLastMonthTransaction(transactionType: String): Flow<List<TransactionDataTransferObject>>
}