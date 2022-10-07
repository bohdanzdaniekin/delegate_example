package com.bohdanzdaniekin.delegate.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class Character(
    val id: Int,
    val name: String,
    val status: Status,
    val gender: Gender,
    val species: String,
    val type: String,
    val origin: Location,
    val location: Location,
    val image: String,
    val episode: List<String>,
    val createdAt: Date
): Parcelable, ListItem {

    @IgnoredOnParcel
    override val itemId: Long = id.toLong()
}
