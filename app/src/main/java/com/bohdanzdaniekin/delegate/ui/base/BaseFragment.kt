package com.bohdanzdaniekin.delegate.ui.base

import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.bohdanzdaniekin.delegate.R
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.sample
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

abstract class BaseFragment<VB : ViewBinding>(
    @LayoutRes layoutId: Int
) : DaggerFragment(layoutId) {

    protected abstract val binding: VB

    protected fun Flow<Throwable>.observeErrors() {
        lifecycleScope.launch {
            sample(TimeUnit.SECONDS.toMillis(1)).collect {
                if (lifecycle.currentState >= Lifecycle.State.STARTED) {
                    Toast.makeText(context, R.string.default_error, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}