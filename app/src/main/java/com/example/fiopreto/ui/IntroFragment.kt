package com.example.fiopreto.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fiopreto.R

class IntroFragment : Fragment() {

    private lateinit var introButton: AppCompatButton


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_intro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        introButton = view.findViewById(R.id.intro_button)

        introButton.setOnClickListener{

            findNavController().navigate(
                IntroFragmentDirections.actionIntroFragmentToIntro2Fragment2()
            )

            }


    }
}