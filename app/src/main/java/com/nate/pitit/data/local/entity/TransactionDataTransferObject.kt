package com.nate.pitit.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nate.pitit.models.Transaction
import java.util.Date

@Entity(tableName = "transaction_table")
data class TransactionDataTransferObject(
    @PrimaryKey
    @ColumnInfo(name = "timestamp")
    val date: Date,
    @ColumnInfo(name = "entry_date")
    val dateOfEntry: String,
    @ColumnInfo(name = "amount")
    val amount: Double,
    @ColumnInfo(name = "account")
    val account: String,
    @ColumnInfo(name = "category")
    val category: String,
    @ColumnInfo(name = "transaction_type")
    val transactionType: String,
    @ColumnInfo(name = "transaction_title")
    val title: String
){

    fun toTransaction(): Transaction = Transaction(date,dateOfEntry,amount,category,account,transactionType,title)
}
