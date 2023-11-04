package com.nate.pitit.di

import android.content.Context
import androidx.room.Room
import com.nate.pitit.data.local.TransactionDataAccessObject
import com.nate.pitit.data.local.TransactionDatabase
import com.nate.pitit.data.repository.DatastoreRepositoryImpl
import com.nate.pitit.data.repository.TransactionRepositoryImpl
import com.nate.pitit.models.repository.DataStoreRepository
import com.nate.pitit.models.repository.TransactionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ExpenseModule {

    @Provides
    @Singleton
    fun provideDatastoreRepository(@ApplicationContext context: Context) : DataStoreRepository {
        return DatastoreRepositoryImpl(context)
    }

    @Provides
    @Singleton
    fun provideExpenseRepository(transactionDao: TransactionDataAccessObject) : TransactionRepository
            = TransactionRepositoryImpl(transactionDao)

    @Provides
    @Singleton
    fun provideExpenseDatabase(@ApplicationContext context: Context) : TransactionDatabase {
        return Room.databaseBuilder(context, TransactionDatabase::class.java, "transactionDB")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideExpenseDao(database: TransactionDatabase) = database.transactionDao
}