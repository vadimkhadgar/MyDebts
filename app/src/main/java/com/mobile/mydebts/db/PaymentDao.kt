package com.mobile.mydebts.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mobile.mydebts.model.PaymentPhone

@Dao
interface PaymentDao {
    @Query("SELECT * FROM paymentsPhoneLoan")
    fun  getPayments(): LiveData<List<PaymentPhone>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(payment: PaymentPhone)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun update(payment: PaymentPhone)

    @Query("DELETE FROM paymentsPhoneLoan")
    suspend fun deleteAll()
}