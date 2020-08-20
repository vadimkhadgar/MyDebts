package com.mobile.mydebts

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "payments")
data class Payment(
    @PrimaryKey
    val id: Int,
    val amountOfPayment: String,
    val isPaid: Boolean,
)