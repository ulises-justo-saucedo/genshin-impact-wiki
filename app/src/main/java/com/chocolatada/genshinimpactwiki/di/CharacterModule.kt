package com.chocolatada.genshinimpactwiki.di

import com.chocolatada.genshinimpactwiki.data.dao.CharacterDao
import com.chocolatada.genshinimpactwiki.data.repository.character.CharacterRepositoryImpl
import com.chocolatada.genshinimpactwiki.data.repository.character.ICharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CharacterModule {
    @Provides
    @Singleton
    fun provideCharacterRepository(
        characterApiDao: CharacterDao
    ): ICharacterRepository = CharacterRepositoryImpl(characterApiDao)

    @Provides
    @Singleton
    fun provideCharacterDao(httpClient: HttpClient): CharacterDao = CharacterDao(httpClient)
}