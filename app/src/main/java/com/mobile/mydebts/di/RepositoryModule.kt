package com.mobile.mydebts.di

import com.mobile.mydebts.db.PaymentDao
import com.mobile.mydebts.db.PaymentsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun providePaymentsRepository(
        paymentDao: PaymentDao
    ): PaymentsRepository {
        return PaymentsRepository(paymentDao)
    }
}