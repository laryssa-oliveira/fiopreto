package com.example.fiopreto.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.example.fiopreto.data.remote.login.LoginRequest
import com.example.fiopreto.R
import com.example.fiopreto.data.remote.postSalon.SalonRepositoryImpl
import com.example.fiopreto.data.remote.login.LoginService
import com.example.fiopreto.presentation.LoginViewModel
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.fiopreto.presentation.ViewState.State.*
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_login.*
import retrofit2.Response

class LoginFragment : Fragment() {

    private lateinit var button: AppCompatButton
    private lateinit var buttonReg: AppCompatButton
    private lateinit var edtEmail: TextInputEditText
    private lateinit var edtPassword: TextInputEditText
    private lateinit var viewLoading: View

    //private lateinit var progressBar: ProgressBar
    private val loginViewModel by viewModel<LoginViewModel>()
    //private lateinit var loadingGroup: Group

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
        //viewLoading = view.findViewById(R.id.viewLoading)
        //progressBar = view.findViewById(R.id.progressBar)
        //loadingGroup = view.findViewById(R.id.loadingGroup)
        edtPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        edtPassword.afterTextChanged {
            layoutEdtPassword.helperText = null
            login_button.setBackgroundResource(R.drawable.background_button)
            login_button.setText("Fazer login")
        }

        edtEmail.afterTextChanged {
            layoutEdtPassword.helperText = null
            login_button.setBackgroundResource(R.drawable.background_button)
            login_button.setText("Fazer login")
        }

        button.setOnClickListener {

            loginViewModel.login(edtEmail.text.toString(), edtPassword.text.toString())
        }

        buttonReg.setOnClickListener {
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToIntroFragment()
            )
        }

        setObservers()
        //onLoading(false)
    }

    private fun setObservers() {
        loginViewModel.headersLiveData.observe(viewLifecycleOwner, {
            when (it.state) {

                SUCCESS -> onResultSuccess()
                ERROR -> onResultError(it.error)
                //LOADING -> onLoading(it.isLoading)
            }

        })

    }

    fun TextInputEditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                afterTextChanged.invoke(editable.toString())
            }
        })
    }

    /*
    private fun onLoading(loading: Boolean) {
        if(loading)
            loadingGroup.visibility = View.VISIBLE
        else
            loadingGroup.visibility = View.GONE

    }*/

    private fun onResultError(error: Throwable?) {
        Toast.makeText(requireContext(), error?.message ?: "", Toast.LENGTH_LONG).show()

        layoutEdtPassword.helperText = "Credenciais incorretas*"
        login_button.setBackgroundResource(R.drawable.background_button_red)
        login_button.setText("X")

        /*if (layoutEdtPassword.isSelected) {
            validateAgain()
        }
        //validateAgain()
    }

    private fun validateAgain() {
        if(edtPassword.text.toString()!=null)
            layoutEdtPassword.helperText = null
            login_button.setBackgroundResource(R.drawable.background_button)
            login_button.setText("Fazer login")*/

    }


        private fun onResultSuccess() {
            val changePage = Intent(requireActivity(), HomeActivity::class.java)
            startActivity(changePage)
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToHomeGraph()
            )
            loginViewModel.clearStatus()


        }





}

/*
class LoginFragment : Fragment() {

    private lateinit var button: AppCompatButton
    private lateinit var edtEmail: TextInputEditText
    private lateinit var edtPassword: TextInputEditText
    private lateinit var buttonReg: AppCompatButton
    private lateinit var layoutPassword: TextInputEditText
    private lateinit var sessionManager: SalonRepositoryImpl.SessionManager


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
        sessionManager = SalonRepositoryImpl.SessionManager(this.requireContext())
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
                response.headers().get("token")?.let { it1 -> sessionManager.saveAuthToken(it1) }

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

}*/

