package com.mobile.mydebts.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.mobile.mydebts.db.PaymentsRepository

class PaymentsViewModel @ViewModelInject constructor(private val paymentsRepository: PaymentsRepository) :
    ViewModel() {

}