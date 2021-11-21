package com.example.ecothon.ui.customUIPackage

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import com.example.ecothon.R
import com.example.ecothon.Utility

class CustomEditText @JvmOverloads constructor(
    context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int = android.R.attr.editTextStyle
) : AppCompatEditText(context, attributeSet,  defStyleAttr){

//class CustomEditText : AppCompatTextView {
//
//    constructor(context: Context) : this(context, null)
//    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
//    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onFocusChanged(focused: Boolean, direction: Int, previouslyFocusedRect: Rect?) {
        Utility().hideSoftKeyboard(context as Activity)
//        Log.d("Context", (context as Activity).toString())
        super.onFocusChanged(focused, direction, previouslyFocusedRect)
    }

    override fun setOnClickListener(l: OnClickListener?) {
        Log.d("Custom", "On CLick Check")
        super.setOnClickListener(l)
    }

}