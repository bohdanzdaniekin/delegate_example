package com.bohdanzdaniekin.delegate.domain.datasource

import com.bohdanzdaniekin.delegate.data.remote.entity.PagedResult
import com.bohdanzdaniekin.delegate.domain.entity.Character
import com.bohdanzdaniekin.delegate.domain.entity.Gender
import com.bohdanzdaniekin.delegate.domain.entity.Resource
import com.bohdanzdaniekin.delegate.domain.entity.Status

interface CharacterDataSource {

    suspend fun getCharacterById(characterId: Int): Resource<Character>

    suspend fun getCharactersByIds(charactersIds: List<Int>): Resource<List<Character>>

    suspend fun getCharacters(
        page: Int? = null,
        name: String? = null,
        status: Status? = null,
        gender: Gender? = null,
        species: String? = null,
        type: String? = null
    ): PagedResult<List<Character>>
}