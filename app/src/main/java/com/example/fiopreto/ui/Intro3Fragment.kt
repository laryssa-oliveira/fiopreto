package com.example.fiopreto.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fiopreto.R

class Intro3Fragment : Fragment() {
    private lateinit var introButtonNext: AppCompatButton
    private lateinit var introButtonBack: AppCompatButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_intro3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        introButtonNext = view.findViewById(R.id.intro3_button_next)
        introButtonBack = view.findViewById(R.id.intro3_button_back)

        introButtonNext.setOnClickListener{

            findNavController().navigate(
                Intro3FragmentDirections.actionIntro3FragmentToIntro4Fragment()
            )

        }

        introButtonBack.setOnClickListener{
            findNavController().navigate(
                Intro3FragmentDirections.actionIntro3FragmentToIntro2Fragment2()
            )
        }


    }
}