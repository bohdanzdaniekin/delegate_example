package com.bohdanzdaniekin.delegate.data.remote.datasource

import com.bohdanzdaniekin.delegate.data.parser.ResponseParser
import com.bohdanzdaniekin.delegate.data.remote.api.RickAndMortyApi
import com.bohdanzdaniekin.delegate.data.remote.entity.CharacterDto
import com.bohdanzdaniekin.delegate.data.remote.entity.PagedResult
import com.bohdanzdaniekin.delegate.data.remote.entity.map
import com.bohdanzdaniekin.delegate.data.remote.entity.toCharacter
import com.bohdanzdaniekin.delegate.domain.datasource.CharacterDataSource
import com.bohdanzdaniekin.delegate.domain.entity.Character
import com.bohdanzdaniekin.delegate.domain.entity.Gender
import com.bohdanzdaniekin.delegate.domain.entity.Resource
import com.bohdanzdaniekin.delegate.domain.entity.Status
import com.bohdanzdaniekin.delegate.domain.util.DispatcherProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterRemoteDataSource @Inject constructor(
    private val api: RickAndMortyApi,
    private val dispatcherProvider: DispatcherProvider,
    private val responseParser: ResponseParser
) : CharacterDataSource {

    override suspend fun getCharacterById(characterId: Int): Resource<Character> {
        return withContext(dispatcherProvider.io) {
            responseParser.getResponse {
                api.getCharacterById(characterId)
            }.mapNotNull(CharacterDto::toCharacter)
        }
    }

    override suspend fun getCharactersByIds(charactersIds: List<Int>): Resource<List<Character>> {
        return withContext(dispatcherProvider.io) {
            responseParser.getResponse {
                api.getCharactersByIds(charactersIds.joinToString(","))
            }.mapNotNull { characters ->
                characters.map(CharacterDto::toCharacter)
            }
        }
    }

    override suspend fun getCharacters(
        page: Int?,
        name: String?,
        status: Status?,
        gender: Gender?,
        species: String?,
        type: String?
    ): PagedResult<List<Character>> {
        return withContext(dispatcherProvider.io) {
            api.getCharacters(
                page = page,
                name = name,
                status = status?.value?.lowercase(),
                gender = gender?.value?.lowercase(),
                species = species,
                type = type
            ).map { characters ->
                characters.map(CharacterDto::toCharacter)
            }
        }
    }
}