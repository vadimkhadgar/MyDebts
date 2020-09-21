package com.mobile.mydebts.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "paymentsPhoneLoan")
data class PaymentPhone(
    @PrimaryKey
    val id: Int,
    val amountOfPayment: String,
    val isPaid: Boolean,
)