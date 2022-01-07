package com.example.ecothon.ui.learnings.fragmentLearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ecothon.R
import com.example.ecothon.databinding.ActivityFragmentLearningBinding

class FragmentLearningActivity : AppCompatActivity() {

    lateinit var binding: ActivityFragmentLearningBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentLearningBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

}