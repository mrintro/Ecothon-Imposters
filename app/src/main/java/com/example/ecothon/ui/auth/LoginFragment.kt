package com.example.ecothon.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.example.ecothon.databinding.FragmentLoginBinding
import com.example.ecothon.repository.AuthRepository
import com.example.ecothon.ui.base.BaseFragment
import com.google.android.gms.common.api.Api

class LoginFragment : BaseFragment<AuthViewModel, FragmentLoginBinding, AuthRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun getViewModel() = AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLoginBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = AuthRepository(remoteDataSource.buildApi(Api::class.java))

}