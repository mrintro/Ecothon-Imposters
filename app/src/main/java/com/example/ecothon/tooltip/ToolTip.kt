package com.example.ecothon.tooltip

import android.content.Context
import android.content.res.Resources
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.PopupWindow
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.annotation.MainThread
import androidx.core.view.ViewCompat
import com.example.ecothon.databinding.ToolTipBodyBinding

class ToolTip private constructor(
    private val context: Context,
    private val builder: Builder,
) {


    private val binding = ToolTipBodyBinding.inflate(LayoutInflater.from(context), null, false)

    private val popUp = PopupWindow(
        binding.root,
        FrameLayout.LayoutParams.WRAP_CONTENT,
        FrameLayout.LayoutParams.WRAP_CONTENT
    )

    init {
        initializeBuilder()
    }

    private fun initializeBuilder() {
        // pop up settings
        with(this.popUp) {
            isOutsideTouchable = true
            isFocusable = true
            setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
            isAttachedInDecor = true
        }

    }


    fun showAnchorTop(anchorView: View) {
        show(anchorView)
    }

    @MainThread
    private fun show(anchorView: View) {
        if (canShowAnchor(anchorView)) {
            anchorView.post {
                getTextWidth(binding.popUpText, binding.popUpContainer)
            }
        }
    }

    private fun getTextWidth(textView: TextView, containerView: View) {
        with(textView) {
            var measuredTextWidth = textView.paint.measureText(textView.text.toString()).toInt()
            displaySize
        }
    }

    private fun canShowAnchor(anchorView: View): Boolean =
        popUp.contentView.parent == null && ViewCompat.isAttachedToWindow(anchorView)


    class Builder(
        private val context: Context,
    ) {
        var layoutRes: Int? = null
        var layoutView: View? = null


        private fun setLayoutRes(@LayoutRes layoutRes: Int): Builder = apply {
            this.layoutRes = layoutRes
        }

        private fun setLayoutView(layoutView: View): Builder = apply {
            this.layoutView = layoutView
        }

        fun build(): ToolTip = ToolTip(
            context,
            this@Builder
        )
    }

    internal val displaySize: Point
        @JvmSynthetic inline get() = Point(
            Resources.getSystem().displayMetrics.widthPixels,
            Resources.getSystem().displayMetrics.heightPixels
        )
}
