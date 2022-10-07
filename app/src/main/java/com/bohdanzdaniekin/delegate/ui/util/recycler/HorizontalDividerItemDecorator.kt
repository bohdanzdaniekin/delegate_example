package com.bohdanzdaniekin.delegate.ui.util.recycler

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.Px
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bohdanzdaniekin.delegate.R

class HorizontalDividerItemDecorator constructor(
    context: Context,
    @DimenRes dividerSize: Int = R.dimen.divider_size,
    @ColorRes dividerColor: Int = R.color.divider
) : RecyclerView.ItemDecoration() {

    private val dividerDrawable = ColorDrawable(ContextCompat.getColor(context, dividerColor))

    @Px private val dividerHeight = context.resources.getDimensionPixelSize(dividerSize)

    override fun onDraw(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val dividerLeft = parent.paddingLeft
        val dividerRight = parent.width - parent.paddingRight

        for (i in 0 until parent.childCount - 1) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val dividerTop = child.bottom + params.bottomMargin
            val dividerBottom = dividerTop + dividerHeight

            dividerDrawable.setBounds(dividerLeft, dividerTop, dividerRight, dividerBottom)
            dividerDrawable.draw(canvas)
        }
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.top = dividerHeight
    }
}