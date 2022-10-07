package com.bohdanzdaniekin.delegate.data.remote.api

import com.bohdanzdaniekin.delegate.data.remote.entity.CharacterDto
import com.bohdanzdaniekin.delegate.data.remote.entity.PagedResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApi {

    @GET("api/character/")
    suspend fun getCharacters(
        @Query(value = "page") page: Int? = null,
        @Query(value = "name") name: String? = null,
        @Query(value = "status") status: String? = null,
        @Query(value = "species") species: String? = null,
        @Query(value = "type") type: String? = null,
        @Query(value = "gender") gender: String? = null
    ): PagedResult<List<CharacterDto>>

    @GET("api/character/{id}")
    suspend fun getCharacterById(
        @Path(value = "id") id: Int
    ): Response<CharacterDto>

    @GET("api/character/{ids}")
    suspend fun getCharactersByIds(
        @Path(value = "ids") ids: String
    ): Response<List<CharacterDto>>
}