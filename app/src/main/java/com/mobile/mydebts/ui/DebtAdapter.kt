package com.mobile.mydebts.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobile.mydebts.R
import com.mobile.mydebts.model.PaymentPhone

class DebtAdapter internal constructor(context: Context) :
    RecyclerView.Adapter<DebtAdapter.UserVH>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var payments = emptyList<PaymentPhone>() // Cached copy of users

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserVH {
        val itemView = inflater.inflate(R.layout.item_payment, parent, false)
        return UserVH(itemView)
    }

    override fun getItemCount(): Int {
        return payments.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: UserVH, position: Int) {
        val current = payments[position]
        holder.tvSerialNumber.text = "${current.id}."
        holder.tvPayment.text = "${current.amountOfPayment} blr"
        if (current.isPaid) {
            // TODO: 22.09.2020
        } else {
            // TODO: 22.09.2020
        }
    }

    inner class UserVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvSerialNumber: TextView = itemView.findViewById(R.id.tvSerialNumber)
        val tvPayment: TextView = itemView.findViewById(R.id.tvPayment)
        val ivIsPaid: ImageView = itemView.findViewById(R.id.ivIsPaid)

    }

    internal fun setDataLogs(payments: List<PaymentPhone>) {
        this.payments = payments
        notifyDataSetChanged()
    }
}
