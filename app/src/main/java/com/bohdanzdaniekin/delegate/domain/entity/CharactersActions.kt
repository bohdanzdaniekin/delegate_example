package com.bohdanzdaniekin.delegate.domain.entity

sealed class CharactersActions : Action {

    object Loading : CharactersActions()

    data class Error(val message: String): CharactersActions()



    data class OnRootClicked(val item: Character): CharactersActions()

    data class OnNameClicked(val item: Character): CharactersActions()

    data class OnGenderClicked(val item: Character): CharactersActions()

    data class OnTypeClicked(val item: Character): CharactersActions()
}