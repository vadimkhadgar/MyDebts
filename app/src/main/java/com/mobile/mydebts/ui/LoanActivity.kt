package com.mobile.mydebts.ui

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.mobile.mydebts.R
import com.mobile.mydebts.model.PaymentPhone
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_loan.*

@AndroidEntryPoint
class LoanActivity : AppCompatActivity() {

    private val viewModel: PaymentsViewModel by viewModels()
    private lateinit var adapter: DebtAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loan)

        floatingActionButton.setOnClickListener {
            showAlertDialog()
            viewModel.deleteAll()
        }

        viewModel.getPayments().observe(this, {
            if (it != null) {
                adapter = DebtAdapter(this)
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = adapter
                adapter.setDataLogs(it)
            }
        })
    }

    private fun showAlertDialog() {
        val alertBuilder = MaterialAlertDialogBuilder(this, R.style.CustomDialogStyle)
            .setView(R.layout.add_payment_layout)
            .setCancelable(false)
        val alertDialog = alertBuilder.show()

        val amountOfPayments = alertDialog.findViewById<EditText>(R.id.etAmountOfPayment)
        val quantityOfPayments = alertDialog.findViewById<EditText>(R.id.etQuantityOfPayments)

        alertDialog.findViewById<TextView>(R.id.tvCancel)?.setOnClickListener {
            alertDialog.dismiss()
        }
        alertDialog.findViewById<TextView>(R.id.tvOk)?.setOnClickListener {
            addDebtToDatabase(
                amountOfPayments?.text.toString(),
                quantityOfPayments?.text.toString()
            )
            alertDialog.dismiss()
        }
    }

    private fun addDebtToDatabase(amountOfPayments: String, quantityOfPayments: String) {
        for ((t, x) in (0 until quantityOfPayments.toInt()).withIndex()) {
            viewModel.insertPayment(
                PaymentPhone(
                    id = x + 1,
                    amountOfPayment = amountOfPayments,
                    isPaid = false
                )
            )
        }
    }

    private fun setupRecyclerView() {

    }
}