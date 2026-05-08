package com.example.elvinPrak

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.elvinPrak.databinding.ActivityMainBinding
import com.example.elvinPrak.pertemuan_7.SeventhActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Tambahkan ini agar tampilan tetap modern (Full screen)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengatur padding agar layout tidak tertutup Status Bar/Notch
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inisialisasi SharedPreferences (Nama harus sama dengan di Splash & Auth)
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.logoutBtn.setOnClickListener {
            showLogoutConfirmation(sharedPref)
        }
        binding.btn7.setOnClickListener {
            val intent = Intent(this, SeventhActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showLogoutConfirmation(sharedPref: SharedPreferences) {
        AlertDialog.Builder(this)
            .setTitle("Konfirmasi Logout")
            .setMessage("Apakah Anda yakin ingin keluar?")
            .setPositiveButton("Ya") { dialog, _ ->
                // Proses hapus data
                val editor = sharedPref.edit()
                editor.clear()
                editor.apply()

                Log.e("Logout", "Data dibersihkan, berpindah ke AuthActivity")

                dialog.dismiss()

                // Pindah kembali ke AuthActivity dan bersihkan tumpukan Activity
                val intent = Intent(this, AuthActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
            .setNegativeButton("Tidak") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }


    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart: MainActivity terlihat di layar")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "MainActivity dihapus dari stack")
    }
}