package com.example.fiopreto.ui


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.example.fiopreto.R
import kotlin.system.exitProcess


class ProfileFragment : Fragment() {

    private lateinit var buttonLogout: AppCompatButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonLogout = view.findViewById(R.id.button_logout)

        buttonLogout.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }

        }


    }



}