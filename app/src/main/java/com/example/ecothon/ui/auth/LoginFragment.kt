package com.example.ecothon.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.lifecycle.Observer
import com.example.ecothon.Utility
import com.example.ecothon.databinding.FragmentLoginBinding
import com.example.ecothon.network.AuthApi
import com.example.ecothon.network.RemoteDataSource
import com.example.ecothon.network.Resource
import com.example.ecothon.repository.AuthRepository
import com.example.ecothon.ui.base.BaseFragment

class LoginFragment : BaseFragment<AuthViewModel, FragmentLoginBinding, AuthRepository>() {




    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Success -> {
                    Log.d("Login",it.value.toString())
                }
                is Resource.Failure -> {
                    Log.d("Login", "Failure")
                }
            }
        })

        binding.loginButton.setOnClickListener {
            val email = binding.usernameOrEmailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()

            viewModel.login(email, password)
        }

    }

    override fun getViewModel() = AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLoginBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = AuthRepository(RemoteDataSource.buildApi(AuthApi::class.java))

}