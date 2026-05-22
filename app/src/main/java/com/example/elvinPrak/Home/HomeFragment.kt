package com.example.elvinPrak.Home

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.elvinPrak.AuthActivity
import com.example.elvinPrak.Home.pertemuan_2.SecondActivity
import com.example.elvinPrak.Home.pertemuan_3.ThirdActivity
import com.example.elvinPrak.Home.pertemuan_4.FourthActivity
import com.example.elvinPrak.Home.pertemuan_5.FifthActivity
import com.example.elvinPrak.Home.pertemuan_7.SeventhActivity
import com.example.elvinPrak.Home.pertemuan_9.NinthActivity
import com.example.elvinPrak.R
import com.example.elvinPrak.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private lateinit var sharedPref: SharedPreferences
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }

        // 2. Initialize SharedPreferences
        sharedPref = requireContext().getSharedPreferences("YourPrefName", android.content.Context.MODE_PRIVATE)

        binding.btn2.setOnClickListener {
            startActivity(Intent(requireContext(), SecondActivity::class.java))
        }
        binding.btn2.setOnClickListener{
            val intent = Intent(requireContext(), SecondActivity::class.java)
            startActivity(intent)
        }

        binding.btn3.setOnClickListener{
            val intent = Intent(requireContext(), ThirdActivity::class.java)
            startActivity(intent)
        }

        binding.btn4.setOnClickListener{
            val intent = Intent(requireContext(), FourthActivity::class.java)
            startActivity(intent)
        }

        binding.btn5.setOnClickListener{
            val intent = Intent(requireContext(), FifthActivity::class.java)
            startActivity(intent)
        }

        binding.btn7.setOnClickListener{
            val intent = Intent(requireContext(), SeventhActivity::class.java)
            startActivity(intent)
        }

        binding.btn9.setOnClickListener{
            val intent = Intent(requireContext(), NinthActivity::class.java)
            startActivity(intent)
        }

        binding.logoutBtn.setOnClickListener {
            showLogoutConfirmation()
        }
    }
    private fun showLogoutConfirmation() {
        // 3. Use requireContext() instead of 'this'
        AlertDialog.Builder(requireContext())
            .setTitle("Konfirmasi Logout")
            .setMessage("Apakah Anda yakin ingin keluar?")
            .setPositiveButton("Ya") { dialog, _ ->
                val editor = sharedPref.edit()
                editor.clear()
                editor.apply()

                Log.e("Logout", "Data dibersihkan, berpindah ke AuthActivity")
                dialog.dismiss()

                // 4. Use requireContext() for Intent and requireActivity().finish()
                val intent = Intent(requireContext(), AuthActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                requireActivity().finish()
            }
            .setNegativeButton("Tidak") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}