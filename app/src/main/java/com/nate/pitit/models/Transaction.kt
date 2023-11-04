package com.nate.pitit.models

import java.util.Date

data class Transaction (
    val date: Date,
    val dateOfEntry: String,
    val amount: Double,
    val category: String,
    val account: String,
    val transactionType: String,
    val title: String
)