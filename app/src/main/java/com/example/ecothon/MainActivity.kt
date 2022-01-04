package com.example.ecothon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ecothon.ui.auth.AuthActivity
import com.example.ecothon.R
import com.example.ecothon.ui.learnings.fragmentLearning.FragmentLearningActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        finish()
    //  AuthActivity Intent
    //  startActivity(Intent(this, AuthActivity::class.java))


    //  Fragment Learning
    startActivity(Intent(this, FragmentLearningActivity::class.java))

    }
}