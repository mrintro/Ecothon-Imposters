package com.example.ecothon.ui.auth

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.Observer
import com.example.ecothon.R
import com.example.ecothon.databinding.FragmentRegisterBinding
import com.example.ecothon.network.AuthApi
import com.example.ecothon.network.RemoteDataSource
import com.example.ecothon.network.Resource
import com.example.ecothon.repository.AuthRepository
import com.example.ecothon.AuthViewFragmentCallback
import com.example.ecothon.ui.base.BaseFragment
import java.lang.ClassCastException
import java.lang.Exception

class RegisterFragment : BaseFragment<AuthViewModel, FragmentRegisterBinding, AuthRepository>() {

    lateinit var callback : AuthViewFragmentCallback

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Register Fragment", "onDestroy Called")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Register Fragment", "onDestroyView Called")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("Register Fragment", "OnAttach Called")
        try{
            callback = context as AuthViewFragmentCallback
        } catch (error : ClassCastException){
            Log.e("Register Fragment", error.message.toString())
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.signUpResponse.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Success -> {
                    Toast.makeText(activity, "Account created successfully", Toast.LENGTH_LONG).show()
                    binding.name.setText("")
                    binding.email.setText("")
                    binding.password.setText("")
                    binding.confirmPassword.setText("")
                    binding.username.setText("")
                    try {
                        callback.goto(0)
                    } catch (error : Exception){
                        Log.e("Cannot switch the fragment", error.message.toString())
                    }
                }
                else -> {
                    Log.e("Cannot create a new user", it.toString())
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