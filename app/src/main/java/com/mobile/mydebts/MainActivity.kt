package com.mobile.mydebts

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardView.setOnClickListener {
            startActivity(Intent(this, LoanActivity::class.java).putExtra("Phone", "Phone"))
        }

        cardView2.setOnClickListener {
            startActivity(Intent(this, LoanActivity::class.java).putExtra("Watch", "Watch"))
        }

        cardView3.setOnClickListener {
            startActivity(Intent(this, LoanActivity::class.java).putExtra("Computer", "Computer"))
        }
    }
}