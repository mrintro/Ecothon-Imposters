package com.example.ecothon.ui.learnings.fragmentLearning

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ecothon.R
import java.lang.ClassCastException

class BlankFragment : Fragment() {

    object Constants {
        const val NONE = 2
    }
    var mRadioButtonChoice = Constants.NONE
    lateinit var listener : onFragmentInteractionListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is onFragmentInteractionListener)
            listener = context as onFragmentInteractionListener
        else
            throw ClassCastException(context.toString())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }
}

interface onFragmentInteractionListener {
    fun onRadioButtonChoice(choice : Int)
}