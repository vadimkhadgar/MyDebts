package com.mobile.mydebts.db

import androidx.lifecycle.LiveData
import com.mobile.mydebts.base.Repository
import com.mobile.mydebts.model.PaymentPhone
import javax.inject.Inject

class PaymentsRepository @Inject constructor(private val paymentDao: PaymentDao) : Repository {

    val allPayments: LiveData<List<PaymentPhone>> = paymentDao.getPayments()

    suspend fun insert(payment: PaymentPhone) {
        paymentDao.insert(payment = payment)
    }

    suspend fun update(payment: PaymentPhone) {
        paymentDao.update(payment = payment)
    }
}