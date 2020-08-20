package com.mobile.mydebts

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class PaymentsViewModel @ViewModelInject constructor(private val paymentsRepository: PaymentsRepository) :
    ViewModel() {

}