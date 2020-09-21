package com.mobile.mydebts.di

import android.app.Application
import androidx.room.Room
import com.mobile.mydebts.db.PaymentDao
import com.mobile.mydebts.db.PaymentRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun providePaymentRoomDatabase(application: Application): PaymentRoomDatabase {
        return Room
            .databaseBuilder(application, PaymentRoomDatabase::class.java, "Payments.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providePaymentDao(paymentRoomDatabase: PaymentRoomDatabase): PaymentDao {
        return paymentRoomDatabase.paymentDao()
    }
}