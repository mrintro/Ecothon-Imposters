package com.example.ecothon.ui.customUIPackage

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat.getSystemService
import com.example.ecothon.MainActivity
import com.example.ecothon.R
import com.example.ecothon.Utility

class CustomEditText @JvmOverloads constructor(
    context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int = android.R.attr.editTextStyle
) : AppCompatEditText(context, attributeSet,  defStyleAttr){

    private val contextStored = context as Activity


    override fun onFocusChanged(focused: Boolean, direction: Int, previouslyFocusedRect: Rect?) {
        Log.d("Focus", (context as Activity).currentFocus.toString())
        if(!focused) {
            var inputMethodManager =
                contextStored.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            val res = inputMethodManager.hideSoftInputFromWindow(applicationWindowToken, 0)
        }
        super.onFocusChanged(focused, direction, previouslyFocusedRect)
    }

}