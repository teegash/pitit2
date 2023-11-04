package com.nate.pitit.models.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    suspend fun writeOnboardingKeyToDatastore(completed: Boolean)

    suspend fun readOnboardingKeyFromDataStore(): Flow<Boolean>

    suspend fun writeCurrencyToDatastore(currency: String)

    suspend fun readCurrencyFromDatastore(): Flow<String>

    suspend fun writeExpenseLimitToDatastore(amount: Double)

    suspend fun readExpenseLimitFromDatastore(): Flow<Double>

    suspend fun writeLimitKeyToDatastore(enabled: Boolean)

    suspend fun readLimitKeyFromDatastore(): Flow<Boolean>

    suspend fun writeLimitDurationToDatastore(duration: Int)

    suspend fun readLimitDurationFromDatastore(): Flow<Int>

    suspend fun eraseDatastore()
}