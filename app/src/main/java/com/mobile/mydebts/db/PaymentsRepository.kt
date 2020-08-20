package com.mobile.mydebts.db

import androidx.lifecycle.LiveData
import com.mobile.mydebts.base.Repository
import com.mobile.mydebts.model.Payment
import javax.inject.Inject

class PaymentsRepository @Inject constructor(private val paymentDao: PaymentDao) : Repository {

    val allPayments: LiveData<List<Payment>> = paymentDao.getPayments()

    suspend fun insert(payment: Payment) {
        paymentDao.insert(payment = payment)
    }
}