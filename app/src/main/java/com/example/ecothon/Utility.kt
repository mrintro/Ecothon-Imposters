package com.example.ecothon

import android.app.Activity
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService

class Utility {

    public fun hideSoftKeyboard(activity : Activity){
        var inputMethodManager = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
//        Log.d("Context Utility",)
        if(inputMethodManager.isAcceptingText){
            Log.d("Utility", activity.currentFocus.toString())
            val res = inputMethodManager.hideSoftInputFromWindow(activity.currentFocus?.windowToken, 0)
            Log.d("Utility", res.toString())
        }
    }

    public fun Activity.hideSoftKeyboard2(){
        var inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
//        Log.d("Context Utility", Activity.toString())
        if(inputMethodManager.isAcceptingText){
            Log.d("Utility", currentFocus.toString())
            val res = inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
            Log.d("Utility", res.toString())
        }
    }
}