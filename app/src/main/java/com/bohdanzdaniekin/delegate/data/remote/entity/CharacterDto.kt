package com.bohdanzdaniekin.delegate.data.remote.entity

import com.bohdanzdaniekin.delegate.domain.entity.Character
import com.bohdanzdaniekin.delegate.domain.entity.Gender
import com.bohdanzdaniekin.delegate.domain.entity.Status
import com.bohdanzdaniekin.delegate.ui.util.date.DateTimeFormats
import com.bohdanzdaniekin.delegate.ui.util.date.DateTimeFormatter
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterDto(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: LocationDto,
    val location: LocationDto,
    val image: String,
    val episode: List<String>,
    val url: String,
    @Json(name = "created")
    val createdAt: String
)

fun CharacterDto.toCharacter(): Character {
    return Character(
        id = id,
        name = name,
        status = Status.from(status),
        gender = Gender.from(gender),
        species = species,
        type = type,
        origin = origin.toLocation(),
        location = location.toLocation(),
        image = image,
        episode = episode,
        createdAt = DateTimeFormatter.parse(createdAt, DateTimeFormats.FULL_DATE_TIME_T)
    )
}
