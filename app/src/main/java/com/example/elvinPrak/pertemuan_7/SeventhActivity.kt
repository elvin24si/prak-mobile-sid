package com.example.elvinPrak.pertemuan_7

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.elvinPrak.R
import com.example.elvinPrak.databinding.ActivitySeventhBinding
import com.example.elvinPrak.databinding.ActivityWebViewBinding
import com.example.elvinPrak.pertemuan_3.ThirdResultActivity

class SeventhActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySeventhBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySeventhBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        replaceFragment(SatuFragment())

        // Setup event click untuk mengganti fragment
        binding.btnFrag1.setOnClickListener {
            replaceFragment(SatuFragment())
        }

        binding.btnFrag2.setOnClickListener {
            replaceFragment(DuaFragment())
        }

        binding.btnFrag3.setOnClickListener {
            replaceFragment(TigaFragment())
        }
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Pertemuan 7"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .addToBackStack(null)
            .commit()
    }
}