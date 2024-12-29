package com.chocolatada.genshinimpactwiki.di

import com.chocolatada.genshinimpactwiki.data.dao.CharacterDao
import com.chocolatada.genshinimpactwiki.data.repository.character.CharacterRepositoryImpl
import com.chocolatada.genshinimpactwiki.data.repository.character.ICharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(
        characterApiDao: CharacterDao
    ): ICharacterRepository = CharacterRepositoryImpl(characterApiDao)

    @Provides
    @Singleton
    fun provideCharacterDao(httpClient: HttpClient): CharacterDao = CharacterDao(httpClient)


}