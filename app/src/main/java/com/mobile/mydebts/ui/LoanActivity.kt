package com.mobile.mydebts.ui

import android.os.Bundle
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.mobile.mydebts.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_loan.*

@AndroidEntryPoint
class LoanActivity : AppCompatActivity() {

    private val viewModel: PaymentsViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loan)

        floatingActionButton.setOnClickListener {
            showAlertDialog()
        }
    }

    private fun showAlertDialog() {
        val alertBuilder = MaterialAlertDialogBuilder(this, R.style.CustomDialogStyle)
            .setView(R.layout.add_payment_layout)
            .setCancelable(false)
        val alertDialog = alertBuilder.show()
//        alertDialog.findViewById<EditText>(R.id.etAmountOfPayment)?.setOnClickListener {
//          //  alertDialog.dismiss()
//        }
//        alertDialog.findViewById<EditText>(R.id.etQuantityOfPayments)?.setOnClickListener {
//         //   alertDialog.dismiss()
//        }
    }
}