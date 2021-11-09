package com.example.ecothon.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.example.ecothon.R
import com.example.ecothon.databinding.FragmentLoginBinding
import com.example.ecothon.repository.AuthRepository
import com.example.ecothon.ui.base.BaseFragment

class LoginFragment : BaseFragment<ViewModel, FragmentLoginBinding, AuthRepository>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

}