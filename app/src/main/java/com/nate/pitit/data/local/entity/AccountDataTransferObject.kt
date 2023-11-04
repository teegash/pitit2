package com.nate.pitit.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nate.pitit.models.Account


@Entity(tableName = "accounts_table")
data class AccountDataTransferObject(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    val id: Int,
    @ColumnInfo(name = "account")
    val accountType: String,
    @ColumnInfo(name = "balance")
    var balance: Double,
    @ColumnInfo(name = "income")
    var income: Double,
    @ColumnInfo(name = "expense")
    var expense: Double
){

    fun toAccount() : Account = Account(accountType,balance,income,expense)
}
