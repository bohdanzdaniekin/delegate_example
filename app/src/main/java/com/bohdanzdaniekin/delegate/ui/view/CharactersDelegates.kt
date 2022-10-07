package com.bohdanzdaniekin.delegate.ui.view

import com.bohdanzdaniekin.delegate.R
import com.bohdanzdaniekin.delegate.databinding.ItemCharacterBinding
import com.bohdanzdaniekin.delegate.databinding.ItemCharacterDeadBinding
import com.bohdanzdaniekin.delegate.databinding.ItemErrorBinding
import com.bohdanzdaniekin.delegate.databinding.ItemProgressBinding
import com.bohdanzdaniekin.delegate.domain.entity.Character
import com.bohdanzdaniekin.delegate.domain.entity.CharactersActions
import com.bohdanzdaniekin.delegate.domain.entity.ErrorItem
import com.bohdanzdaniekin.delegate.domain.entity.ListItem
import com.bohdanzdaniekin.delegate.domain.entity.LoadingItem
import com.bohdanzdaniekin.delegate.ui.util.OnActionListener
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object CharactersDelegates {

    fun loadingDelegate(listener: OnActionListener<CharactersActions>) =
        adapterDelegateViewBinding<LoadingItem, ListItem, ItemProgressBinding>(
            { inflater, parent -> ItemProgressBinding.inflate(inflater, parent, false) }
        ) {

            binding.root.setOnClickListener {
                listener.onAction(CharactersActions.Loading)
            }

            bind { payloads ->

            }

            onViewRecycled {

            }
        }

    fun errorDelegate(listener: OnActionListener<CharactersActions>) =
        adapterDelegateViewBinding<ErrorItem, ListItem, ItemErrorBinding>(
            { inflater, parent -> ItemErrorBinding.inflate(inflater, parent, false) }
        ) {

            binding.btnRefreshList.setOnClickListener {
                listener.onAction(CharactersActions.Error(item.message))
            }

            bind { payloads ->

                binding.tvErrorMessage.text = item.message
            }

            onViewRecycled {

            }
        }

    fun characterDelegate(
        glide: RequestManager,
        listener: OnActionListener<CharactersActions>
    ) = adapterDelegateViewBinding<Character, ListItem, ItemCharacterBinding>(
        viewBinding = { inflater, parent -> ItemCharacterBinding.inflate(inflater, parent, false) }
    ) {

        binding.root.setOnClickListener {
            listener.onAction(CharactersActions.OnRootClicked(item))
        }

        bind {
            val resources = binding.root.resources

            with(binding) {
                glide
                    .load(item.image)
                    .transform(
                        CenterCrop(),
                        RoundedCorners(resources.getDimensionPixelOffset(R.dimen.radius_default))
                    )
                    .into(ivCharacterImage)
            }
        }

        onViewRecycled {
            glide.clear(binding.ivCharacterImage)
        }
    }

    fun characterDeadDelegate(
        glide: RequestManager,
        listener: OnActionListener<CharactersActions>
    ) = adapterDelegateViewBinding<Character, ListItem, ItemCharacterDeadBinding>(
        viewBinding = { inflater, parent -> ItemCharacterDeadBinding.inflate(inflater, parent, false) },
        on = { item, items, position -> item is Character && item.status.isDead() }
    ) {

        binding.root.setOnClickListener {
            listener.onAction(CharactersActions.OnRootClicked(item))
        }

        bind {
            val resources = binding.root.resources

            with(binding) {
                glide
                    .load(item.image)
                    .transform(
                        CenterCrop(),
                        RoundedCorners(resources.getDimensionPixelOffset(R.dimen.radius_default))
                    )
                    .into(ivCharacterImage)
            }
        }

        onViewRecycled {
            glide.clear(binding.ivCharacterImage)
        }
    }
}