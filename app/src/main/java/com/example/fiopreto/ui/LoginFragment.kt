package com.example.fiopreto.ui

import android.content.Context
import android.content.Intent
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
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginFragment : Fragment() {

    private lateinit var button: AppCompatButton
    private lateinit var edtEmail: TextInputEditText
    private lateinit var edtPassword: TextInputEditText
    private lateinit var buttonReg: AppCompatButton
    private lateinit var layoutPassword: TextInputEditText
    

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
        buttonReg = view.findViewById(R.id.login_reg_button)
        //layoutPassword = view.findViewById(R.id.layoutEdtPassword)

        /*
        if(edtEmail.text.toString().isEmpty()){
            layoutPassword.setError("*Credenciais incorretas")
        }*/

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

        buttonReg.setOnClickListener{
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToIntroFragment()
            )
        }

    }

    fun handleLogin(response: Response<Unit>) {
        if(response.isSuccessful) {
            val changePage = Intent(requireActivity(), HomeActivity::class.java)
            startActivity(changePage)

            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToHomeGraph()
            )

            Log.d("Login", "header token ${response.headers().get("token")}")

        }

    }

}

