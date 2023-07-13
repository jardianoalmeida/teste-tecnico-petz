package com.jardiano.petz.di

import androidx.paging.ExperimentalPagingApi
import com.jardiano.petz.data.remote.HearthstoneCloudStore
import com.jardiano.petz.data.repository.HearthstoneRepositoryImpl
import com.jardiano.petz.domain.repository.HearthstoneRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object DataModule {
    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @ActivityRetainedScoped
    fun provideHearthstoneRepository(remote: HearthstoneCloudStore): HearthstoneRepository {
        return HearthstoneRepositoryImpl(remote)
    }

}