package com.example.ecothon.ui.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.ecothon.R
import com.example.ecothon.databinding.FragmentRegisterBinding
import com.example.ecothon.network.AuthApi
import com.example.ecothon.network.RemoteDataSource
import com.example.ecothon.network.Resource
import com.example.ecothon.repository.AuthRepository
import com.example.ecothon.ui.base.BaseFragment

class RegisterFragment : BaseFragment<AuthViewModel, FragmentRegisterBinding, AuthRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.signUpResponse.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Success -> {

                }
                else -> {

                }
            }
        })

        binding.registerButton.setOnClickListener{
            val email = binding.email.text.toString().trim()
            val name = binding.name.text.toString().trim()
            val password = binding.password.text.toString().trim()
            val username = binding.username.text.toString().trim()
            val confirmPassword = binding.confirmPassword.text.toString().trim()

            

            Log.d("Registering","Check if clicked")

            viewModel.signup(email,password,username, name)

        }

    }

    override fun getViewModel() = AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentRegisterBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = AuthRepository(RemoteDataSource.buildApi(AuthApi::class.java))

}