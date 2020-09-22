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

class DebtAdapter internal constructor(
    context: Context,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<DebtAdapter.UserVH>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var payments = emptyList<PaymentPhone>() // Cached copy of users

    interface OnItemClickListener {
        fun onPayClick(position: Int, paymentPhone: PaymentPhone)
    }

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
        holder.tvPayment.text = "${current.amountOfPayment} BYN"
        holder.ivIsPaid.setImageResource(if (current.isPaid) R.drawable.ic_baseline_check_24 else R.drawable.ic_baseline_check_circle_outline_24)
        holder.ivIsPaid.setOnClickListener {
            listener.onPayClick(position, current)
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
