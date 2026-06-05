package com.example.elvinPrak.Message.Tutorial

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.elvinPrak.R
import com.example.elvinPrak.databinding.ActivityBaseBinding
import com.example.elvinPrak.databinding.ActivityTutorialMessageBinding
import com.example.elvinPrak.databinding.FragmentHomeBinding

private lateinit var binding : ActivityTutorialMessageBinding
class TutorialMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTutorialMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val fragmentsList = listOf(Tutorial1Fragment(), Tutorial2Fragment(), Tutorial3Fragment())
        val adapter = TutorialFragmentAdapter(this, fragmentsList)
        binding.tutorialMessageViewPager.adapter = adapter
        binding.dotIndicator.attachTo(binding.tutorialMessageViewPager)
    }
}