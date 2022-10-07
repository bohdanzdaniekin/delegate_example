package com.bohdanzdaniekin.delegate.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bohdanzdaniekin.delegate.R
import com.bohdanzdaniekin.delegate.databinding.FragmentFirstBinding
import com.bohdanzdaniekin.delegate.domain.entity.CharactersActions
import com.bohdanzdaniekin.delegate.ui.base.BaseFragment
import com.bohdanzdaniekin.delegate.ui.util.OnActionListener
import com.bohdanzdaniekin.delegate.ui.util.extensions.launchAndRepeatOnStart
import com.bohdanzdaniekin.delegate.ui.view.CharactersDelegates
import com.bumptech.glide.Glide
import javax.inject.Inject

class FirstFragment : BaseFragment<FragmentFirstBinding>(R.layout.fragment_first),
    OnActionListener<CharactersActions> {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<CharactersViewModel> { viewModelFactory }

    override val binding: FragmentFirstBinding by viewBinding(FragmentFirstBinding::bind)

    private val glide by lazy {
        Glide.with(this)
    }

    private val adapter: CharactersAdapter by lazy {
        CharactersAdapter(
            CharactersDelegates.characterDeadDelegate(glide, this),
            CharactersDelegates.characterDelegate(glide, this),
            CharactersDelegates.errorDelegate(this),
            CharactersDelegates.loadingDelegate(this)
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        observeState()
        fetchCharacters()
    }

    fun fetchCharacters() {
        viewModel.fetchCharacters()
    }

    private fun initUI() {
        with(binding) {

            swipeToRefresh.setOnRefreshListener {
                fetchCharacters()
            }

            rvCharacters.adapter = adapter
            rvCharacters.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun observeState() {
        viewModel.errors.observeErrors()
        launchAndRepeatOnStart {
            viewModel.characters.collect { characters ->
                adapter.items = characters
                binding.swipeToRefresh.isRefreshing = false
            }
        }
    }

    override fun onAction(action: CharactersActions) {
        when(action) {
            CharactersActions.Loading -> {
                //
            }
            is CharactersActions.Error -> {
                fetchCharacters()
            }
            is CharactersActions.OnGenderClicked -> {
                //
            }
            is CharactersActions.OnNameClicked -> {
                //
            }
            is CharactersActions.OnRootClicked -> {
                //
            }
            is CharactersActions.OnTypeClicked -> {
                //
            }
        }
    }
}