package com.example.ecothon.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecothon.network.Resource
import com.example.ecothon.repository.AuthRepository
import com.example.ecothon.response.LoginResponse
import com.example.ecothon.response.SignUpMessage
import kotlinx.coroutines.launch


class AuthViewModel(
    private val repository: AuthRepository
): ViewModel() {

    private val _loginResponse : MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Resource<LoginResponse>>
    get() = _loginResponse
    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginResponse.value = repository.loginWithEmail(email, password)
        }
    }

    private val _signUpResponse : MutableLiveData<Resource<SignUpMessage>> = MutableLiveData()
    val signUpResponse : LiveData<Resource<SignUpMessage>>
    get() = _signUpResponse

    fun signup(email: String, password: String, username: String, name: String) {
        viewModelScope.launch {
            _signUpResponse.value = repository.signUp(email,password, username, name)
        }
    }
}