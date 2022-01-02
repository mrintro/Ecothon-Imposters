package com.example.ecothon.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import androidx.viewpager2.widget.ViewPager2
import com.example.ecothon.ui.auth.adapter.AuthViewPagerAdapter
import com.example.ecothon.databinding.ActivityAuthBinding
import com.example.ecothon.ui.auth.adapter.AuthViewFragmentCallback
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class AuthActivity : AppCompatActivity() , AuthViewFragmentCallback {

    lateinit var tabLayout:  TabLayout
    lateinit var viewPager: ViewPager2
    lateinit var binding : ActivityAuthBinding
    val titles = arrayListOf<String>("Login", "Register")

    override fun onCreate(savedInstanceState: Bundle?) {

        println("Check log")
        Log.d("Check","print nahi hona chahiye")
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        val view = binding.root
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(view)

        viewPager = binding.ViewPager
        tabLayout = binding.tabLayout

        setUpLoginTabs()

    }

    private fun setUpLoginTabs() {
        val adapter = AuthViewPagerAdapter(this)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = titles[position]
        }.attach()
    }

    override fun goto(pos: Int) {
        viewPager.setCurrentItem(pos)
    }
}