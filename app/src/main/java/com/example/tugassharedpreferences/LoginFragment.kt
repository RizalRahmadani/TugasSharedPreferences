package com.example.tugassharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.tugassharedpreferences.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    lateinit var binding : FragmentLoginBinding
    lateinit var sharedLogin : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentLoginBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedLogin = requireContext().getSharedPreferences("dataUser", Context.MODE_PRIVATE)

        binding.tvRegister.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        binding.btnLogin.setOnClickListener{
            var getDataUser = sharedLogin.getString("user", "")
            var getDataPass = sharedLogin.getString("password", "")
            var user = binding.etUsername.text.toString()
            var pass = binding.etPass.text.toString()


            if (user.isEmpty() || pass.isEmpty()){
                Toast.makeText(context, "Username dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
            else if(user == getDataUser.toString() && pass == getDataPass.toString()){

                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                Toast.makeText(context, "Login Berhasil", Toast.LENGTH_SHORT).show()
            }
            else if(user != getDataUser.toString() || pass != getDataPass.toString()){
                Toast.makeText(context, "Username dan Pasword anda salah",Toast.LENGTH_SHORT).show()
            }

        }
    }

}