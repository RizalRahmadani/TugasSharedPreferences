package com.example.tugassharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tugassharedpreferences.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
        lateinit var binding : FragmentHomeBinding
        lateinit var sharedHome : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedHome = requireContext().getSharedPreferences("dataUser", Context.MODE_PRIVATE)

        var getUser = sharedHome.getString("fullName","")
        binding.tvFullName.text = "Hello $getUser selamat datang di tampilan home"


        binding.btnLogout.setOnClickListener{
            var pref = sharedHome.edit()
            pref.clear()
            pref.clear()
            findNavController().navigate(R.id.action_homeFragment_to_loginFragment)

        }
    }

}