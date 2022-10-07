package com.bohdanzdaniekin.delegate.data.remote.repository

import com.bohdanzdaniekin.delegate.domain.datasource.CharacterDataSource
import com.bohdanzdaniekin.delegate.domain.entity.Character
import com.bohdanzdaniekin.delegate.domain.entity.ErrorItem
import com.bohdanzdaniekin.delegate.domain.entity.Gender
import com.bohdanzdaniekin.delegate.domain.entity.ListItem
import com.bohdanzdaniekin.delegate.domain.entity.LoadingItem
import com.bohdanzdaniekin.delegate.domain.entity.Resource
import com.bohdanzdaniekin.delegate.domain.entity.Status
import com.bohdanzdaniekin.delegate.domain.repository.CharacterRepository
import com.bohdanzdaniekin.delegate.domain.util.DispatcherProvider
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CharacterRemoteRepository @Inject constructor(
    private val characterDataSource: CharacterDataSource,
    private val dispatcherProvider: DispatcherProvider
) : CharacterRepository {

    override suspend fun getCharacterById(characterId: Int): Flow<Resource<Character>> {
        return flow {
            emit(Resource.loading())
            emit(characterDataSource.getCharacterById(characterId))
        }
            .catch { cause -> Resource.error<Character>(cause.localizedMessage.orEmpty(), cause) }
            .flowOn(dispatcherProvider.io)
    }

    override suspend fun getCharactersByIds(charactersIds: List<Int>): Flow<Resource<List<Character>>> {
        return flow {
            emit(Resource.loading())
            emit(characterDataSource.getCharactersByIds(charactersIds))
        }
            .catch { cause -> Resource.error<Character>(cause.localizedMessage.orEmpty(), cause) }
            .flowOn(dispatcherProvider.io)
    }

    override suspend fun getCharacters(
        page: Int?,
        name: String?,
        status: Status?,
        gender: Gender?,
        species: String?,
        type: String?
    ): Flow<List<ListItem>> {
        return flow {
            emit((1..15).map { LoadingItem })

            delay(TimeUnit.SECONDS.toMillis(3))

            emit(
                characterDataSource
                    .getCharacters(page, name, status, gender, species, type)
                    .results
            )

            delay(TimeUnit.SECONDS.toMillis(6))
            throw IllegalStateException("Hey. We threw error here!")
        }
            .catch { cause -> emit(listOf(ErrorItem(cause.localizedMessage.orEmpty(), cause))) }
            .flowOn(dispatcherProvider.io)
    }
}