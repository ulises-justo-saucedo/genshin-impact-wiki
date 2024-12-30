package com.chocolatada.genshinimpactwiki.di

import com.chocolatada.genshinimpactwiki.data.dao.ArtifactDao
import com.chocolatada.genshinimpactwiki.data.repository.artifact.ArtifactRepositoryImpl
import com.chocolatada.genshinimpactwiki.data.repository.artifact.IArtifactRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ArtifactModule {
    @Provides
    @Singleton
    fun provideArtifactRepository(
        artifactApiDao: ArtifactDao
    ): IArtifactRepository = ArtifactRepositoryImpl(artifactApiDao)

    @Provides
    @Singleton
    fun provideArtifactDao(httpClient: HttpClient): ArtifactDao = ArtifactDao(httpClient)
}