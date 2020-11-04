package com.mobile.mydebts.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.distinctUntilChanged
import androidx.lifecycle.viewModelScope
import com.mobile.mydebts.db.PaymentsRepository
import com.mobile.mydebts.model.PaymentPhone
import kotlinx.coroutines.launch

class PaymentsViewModel @ViewModelInject constructor(private val paymentsRepository: PaymentsRepository) :
    ViewModel() {

    fun getPayments() = paymentsRepository.allPayments.distinctUntilChanged() // Fixing unnecessary updates

    fun insertPayment(payment: PaymentPhone) =
        viewModelScope.launch { paymentsRepository.insert(payment) }

    fun updatePayment(payment: PaymentPhone) =
        viewModelScope.launch { paymentsRepository.update(payment) }

    fun deleteAll() = viewModelScope.launch { paymentsRepository.deleteAll() }

}