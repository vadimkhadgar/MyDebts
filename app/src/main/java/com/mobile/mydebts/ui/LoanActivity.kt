package com.mobile.mydebts.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mobile.mydebts.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoanActivity : AppCompatActivity() {

    private val viewModel: PaymentsViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loan)
    }
}