package com.example.ecothon.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ecothon.databinding.FragmentRecyclerViewBinding
import com.example.ecothon.network.AuthApi
import com.example.ecothon.network.RemoteDataSource
import com.example.ecothon.repository.AuthRepository
import com.example.ecothon.ui.auth.adapter.VPRecyclerViewAdapter
import com.example.ecothon.ui.base.BaseFragment

class RecyclerViewFragment :
    BaseFragment<AuthViewModel, FragmentRecyclerViewBinding, AuthRepository>() {

    override fun getViewModel(): Class<AuthViewModel>  = AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentRecyclerViewBinding = FragmentRecyclerViewBinding.inflate(inflater, container, false)

    override fun getFragmentRepository(): AuthRepository = AuthRepository(RemoteDataSource.buildApi(AuthApi::class.java))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply{
            val list = getList()
            recyclerView.adapter = VPRecyclerViewAdapter(list)
        }
    }

    private fun getList() : List<String> = mutableListOf<String>().apply {
        for(i in 0..15){
            add("String + $i")
        }
    }

}