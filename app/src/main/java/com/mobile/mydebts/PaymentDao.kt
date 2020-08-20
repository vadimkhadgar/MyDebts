package com.mobile.mydebts

import androidx.room.*

@Dao
interface PaymentDao {
    @Query("SELECT * FROM payments")
    fun  getPayments()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(payment: Payment)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun update(payment: Payment)

    @Query("DELETE FROM payments")
    suspend fun deleteAll()
}