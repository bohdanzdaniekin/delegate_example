package com.bohdanzdaniekin.delegate.ui

import com.bohdanzdaniekin.delegate.domain.entity.Gender
import com.bohdanzdaniekin.delegate.domain.entity.ListItem
import com.bohdanzdaniekin.delegate.domain.entity.Status
import com.bohdanzdaniekin.delegate.domain.repository.CharacterRepository
import com.bohdanzdaniekin.delegate.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class CharactersViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : BaseViewModel() {

    private val _characters = MutableStateFlow<List<ListItem>>(emptyList())
    val characters = _characters.asStateFlow()

    fun fetchCharacters(
        page: Int? = null,
        name: String? = null,
        status: Status? = null,
        gender: Gender? = null,
        species: String? = null,
        type: String? = null
    ) {
        runRequest(_characters) {
            characterRepository.getCharacters(page, name, status, gender, species, type)
        }
    }
}