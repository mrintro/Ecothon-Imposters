package com.example.ecothon.auth.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ecothon.auth.LoginFragment
import com.example.ecothon.auth.RegisterFragment


class AuthViewPagerAdapter(
    activity: FragmentActivity
) : FragmentStateAdapter(activity) {


    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> LoginFragment()
            1 -> RegisterFragment()
            else  -> {
                LoginFragment()
            }
        }
    }

}
