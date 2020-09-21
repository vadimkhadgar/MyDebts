package com.mobile.mydebts.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.mobile.mydebts.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPhoneLoan.setOnClickListener {
            startActivity(Intent(this, LoanActivity::class.java).putExtra("Phone", "Phone"))
        }

        btnWatchLoan.setOnClickListener {
            Snackbar.make(it, "Section in development", Snackbar.LENGTH_LONG)
                .setAction(R.string.watch_loan) {
                    // Responds to click on the action
                }
                .show()
        }

        btnComputerLoan.setOnClickListener {
            Snackbar.make(it, "Section in development", Snackbar.LENGTH_LONG)
                .setAction(R.string.computer_loan) {
                    // Responds to click on the action
                }
                .show()
        }
    }
}