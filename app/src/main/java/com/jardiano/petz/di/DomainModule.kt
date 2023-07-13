package com.jardiano.petz.di


import com.jardiano.petz.domain.repository.HearthstoneRepository
import com.jardiano.petz.domain.usecase.GetHearthstoneListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object DomainModule {
    @Provides
    @ActivityRetainedScoped
    fun provideGetHearthstoneListUseCase(repository: HearthstoneRepository): GetHearthstoneListUseCase {
        return GetHearthstoneListUseCase(repository)
    }

}