package com.mobile.mydebts.db

import com.mobile.mydebts.base.Repository
import com.mobile.mydebts.model.PaymentPhone
import javax.inject.Inject

class PaymentsRepository @Inject constructor(private val paymentDao: PaymentDao) : Repository {

    suspend fun getPayments() = paymentDao.getPayments()

    suspend fun insert(payment: PaymentPhone) = paymentDao.insert(payment = payment)

    suspend fun update(payment: PaymentPhone) = paymentDao.update(payment = payment)

}