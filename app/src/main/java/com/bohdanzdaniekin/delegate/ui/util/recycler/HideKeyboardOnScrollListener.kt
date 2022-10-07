package com.bohdanzdaniekin.delegate.ui.util.recycler

import androidx.recyclerview.widget.RecyclerView
import com.bohdanzdaniekin.delegate.ui.util.extensions.hideKeyboard

class HideKeyboardOnScrollListener : RecyclerView.OnScrollListener() {

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        if (RecyclerView.SCROLL_STATE_DRAGGING == newState) recyclerView.hideKeyboard()
    }
}
