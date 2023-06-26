package com.example.ecothon.ui.auth.adapter

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ecothon.ui.auth.LoginFragment
import com.example.ecothon.ui.auth.RecyclerViewFragment
import com.example.ecothon.ui.auth.RegisterFragment


class AuthViewPagerAdapter(
    activity: FragmentActivity
) : FragmentStateAdapter(activity) {


    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        Log.d("fragment position", position.toString())
        return when(position) {
            0 -> LoginFragment()
            1 -> RegisterFragment()
            2 -> RecyclerViewFragment()
            else  -> {
                LoginFragment()
            }
        }
    }


}
