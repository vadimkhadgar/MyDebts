package com.mobile.mydebts.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mobile.mydebts.model.Payment

@Dao
interface PaymentDao {
    @Query("SELECT * FROM payments")
    fun  getPayments(): LiveData<List<Payment>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(payment: Payment)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun update(payment: Payment)

    @Query("DELETE FROM payments")
    suspend fun deleteAll()
}