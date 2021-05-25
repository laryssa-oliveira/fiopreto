package com.example.fiopreto.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fiopreto.R
import com.example.fiopreto.register.RegisterRequest
import com.example.fiopreto.register.RegisterService
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.text.DateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class RegisterFragment : Fragment() {

    private lateinit var regButton: AppCompatButton
    private lateinit var regName: TextInputEditText
    private lateinit var regDob: TextInputEditText
    private lateinit var regEmail: TextInputEditText
    private lateinit var regPassword: TextInputEditText


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        regButton = view.findViewById(R.id.register_button)
        regName = view.findViewById(R.id.edtName)
        regDob = view.findViewById(R.id.edtDob)
        regEmail = view.findViewById(R.id.edtEmail)
        regPassword = view.findViewById(R.id.edtPassword)

        regButton.setOnClickListener{
            CoroutineScope(Dispatchers.Main).launch {
                val response = RegisterService.newInstance().register(
                    RegisterRequest(
                        name = regName.text.toString(),
                        dob = regDob.editableText.toString(),
                        email = regEmail.text.toString(),
                        password = regPassword.text.toString()
                    )
                )
                handleRegister(response)
            }

        }

    }

    private fun handleRegister(response: Response<Unit>) {
        if(response.isSuccessful) {
            Log.d("LOGIN", "header token ${response.headers().get("token")}")
            val changePage = Intent(requireContext(), HomeActivity::class.java)
            startActivity(changePage)
            findNavController().navigate(
                RegisterFragmentDirections.actionRegisterFragmentToHomeGraph()
            )
        }
    }
}