package com.example.fiopreto.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fiopreto.login.LoginRequest
import com.example.fiopreto.R
import com.example.fiopreto.login.LoginService
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginFragment : Fragment() {

    private lateinit var button: AppCompatButton
    private lateinit var edtEmail: TextInputEditText
    private lateinit var edtPassword: TextInputEditText
    

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = view.findViewById(R.id.login_button)
        edtEmail = view.findViewById(R.id.loginEdtEmail)
        edtPassword = view.findViewById(R.id.loginEdtPassword)

        button.setOnClickListener{
            CoroutineScope(Dispatchers.Main).launch {
                val response = LoginService.newInstance().login(
                    LoginRequest(
                    email = edtEmail.text.toString(),
                    password = edtPassword.text.toString()
                )
                )
                handleLogin(response)
            }

        }

    }

    private fun handleLogin(response: Response<Unit>) {
        if(response.isSuccessful)
            Log.d("LOGIN","header token ${response.headers().get("token")}")


            findNavController().navigate(
            LoginFragmentDirections.actionLoginFragmentToHomeFragment())
    }

}

