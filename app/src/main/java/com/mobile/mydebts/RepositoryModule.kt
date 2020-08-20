package com.mobile.mydebts

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