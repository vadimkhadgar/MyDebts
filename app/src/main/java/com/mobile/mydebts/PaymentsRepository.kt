package com.mobile.mydebts

import androidx.lifecycle.LiveData
import javax.inject.Inject

class PaymentsRepository @Inject constructor(private val paymentDao: PaymentDao) : Repository {

    val allPayments: LiveData<List<Payment>> = paymentDao.getPayments()

    suspend fun insert(payment: Payment) {
        paymentDao.insert(payment = payment)
    }
}