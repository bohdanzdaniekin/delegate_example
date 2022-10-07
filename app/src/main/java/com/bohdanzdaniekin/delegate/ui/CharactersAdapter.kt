package com.bohdanzdaniekin.delegate.ui

import com.bohdanzdaniekin.delegate.domain.entity.ListItem
import com.bohdanzdaniekin.delegate.ui.base.BaseDiffUtilItemCallback
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class CharactersAdapter(
    vararg delegates: AdapterDelegate<List<ListItem>>
) : AsyncListDifferDelegationAdapter<ListItem>(BaseDiffUtilItemCallback(), *delegates) {

    override fun getItemId(position: Int): Long = items[position].itemId
}