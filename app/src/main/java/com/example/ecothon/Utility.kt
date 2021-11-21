package com.example.ecothon

import android.app.Activity
import android.util.Log
import android.view.inputmethod.InputMethodManager

class Utility {

    public fun hideSoftKeyboard(activity : Activity){
        var inputMethodManager = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        Log.d("Context Utility", activity.currentFocus?.windowToken.toString())
        if(inputMethodManager.isAcceptingText){
            Log.d("Utility", activity.currentFocus.toString())
            val res = inputMethodManager.hideSoftInputFromWindow(activity.currentFocus?.windowToken, 0)
            Log.d("Utility", res.toString())
        }
    }

}