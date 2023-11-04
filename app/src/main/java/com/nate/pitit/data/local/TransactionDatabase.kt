package com.nate.pitit.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nate.pitit.data.local.converters.DateConverter
import com.nate.pitit.data.local.entity.AccountDataTransferObject
import com.nate.pitit.data.local.entity.TransactionDataTransferObject

@TypeConverters(value = [DateConverter::class])
@Database(entities = [TransactionDataTransferObject::class, AccountDataTransferObject::class], exportSchema = true, version = 1)
abstract class TransactionDatabase: RoomDatabase() {
    abstract val transactionDao: TransactionDataAccessObject
}