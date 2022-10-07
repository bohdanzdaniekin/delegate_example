package com.bohdanzdaniekin.delegate.domain.repository

import com.bohdanzdaniekin.delegate.domain.entity.Character
import com.bohdanzdaniekin.delegate.domain.entity.Gender
import com.bohdanzdaniekin.delegate.domain.entity.ListItem
import com.bohdanzdaniekin.delegate.domain.entity.Resource
import com.bohdanzdaniekin.delegate.domain.entity.Status
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    suspend fun getCharacterById(characterId: Int): Flow<Resource<Character>>

    suspend fun getCharactersByIds(charactersIds: List<Int>): Flow<Resource<List<Character>>>

    suspend fun getCharacters(
        page: Int? = null,
        name: String? = null,
        status: Status? = null,
        gender: Gender? = null,
        species: String? = null,
        type: String? = null
    ): Flow<List<ListItem>>
}