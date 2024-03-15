package com.yash10019coder.domain.di

import com.yash10019coder.data.models.backends.SongsService
import com.yash10019coder.domain.repository.SongsRepo
import com.yash10019coder.domain.repository.SongsRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    fun provideSongsRepo(songsService: SongsService): SongsRepo {
        return SongsRepoImpl(songsService, Dispatchers.IO)
    }
}
