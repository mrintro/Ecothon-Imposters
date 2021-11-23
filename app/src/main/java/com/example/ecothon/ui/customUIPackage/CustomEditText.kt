package com.example.ecothon.ui.customUIPackage

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.os.Looper
import android.util.AttributeSet
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.AppCompatEditText


class CustomEditText @JvmOverloads constructor(
    context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int = android.R.attr.editTextStyle
) : AppCompatEditText(context, attributeSet,  defStyleAttr){

    companion object{
        private var isAnyTextViewFocused = false
    }

    private val contextStored = context as Activity

    override fun callOnClick(): Boolean {
        return super.callOnClick()
    }


    override fun onFocusChanged(focused: Boolean, direction: Int, previouslyFocusedRect: Rect?) {
        if(!focused) {
            isAnyTextViewFocused = false
            android.os.Handler(Looper.getMainLooper()).postDelayed(
                Runnable {
                    kotlin.run {
                        if(!isAnyTextViewFocused){
                            var inputMethodManager =
                                contextStored.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                            val res = inputMethodManager.hideSoftInputFromWindow(applicationWindowToken, 0)
                        }
                    }
                }, 100
            )
        }
        if(focused){
            isAnyTextViewFocused = true
        }
        super.onFocusChanged(focused, direction, previouslyFocusedRect)
    }

}